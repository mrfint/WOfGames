package server.bin;

import protocolcontrol.FactoryProtocolEvMngr;
import protocolcontrol.ProtocolEventMngr;
import eventmodel.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;
import protocolcontrol.Game;

public class ProtocolEventDispetcher extends Thread
{   
    private String prefix;
    private String comm;
    private String args;

    private ProtocolEventMngr evprod = null;
    private final EventsQueue EVQUE = EventsQueue.getInstance();
    
    public ProtocolEventDispetcher() {
        
    }

    @Override
    public void run() {
        
        while (true) {
            
            EventOfProtocol ev = EVQUE.fetchEvent();
            
            if(ev!=null){
                
                try{
                    // *************************Parse EventMeassage
                    String s = ev.getMessage();
                    
                    prefix = s.substring( 0, s.indexOf('_') ); 
                    comm = s.substring( prefix.length()+1, s.indexOf(':') );                
                    args = s.substring(comm.length()+prefix.length()+2).trim();
                    // ************************Set only args in Event Message
                    ev.setMessage(args);
                    
                    evprod = FactoryProtocolEvMngr.getInstance(prefix);

                    switch(comm){
                        case "connectme": evprod.doConnectPlayer(ev);
                            break;
                        case "refresh"  : evprod.firePlayersList(ev);
                            break;
                        case "suggest"  : evprod.doSuggest(ev);
                            break;
                        case "response" : evprod.doResponse(ev);
                            break;
                        case "out"      : evprod.doOut(ev);
                            break;
                        // ************************************Special commands    
                        case "next"     : ((Game)evprod).doNext(ev);
                            break;    
                        default:   evprod.doNothing(ev); 
                    }
                
                }
                catch(StringIndexOutOfBoundsException e){ evprod.doNothing(ev);}
            }
            else{
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProtocolEventDispetcher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    
}
