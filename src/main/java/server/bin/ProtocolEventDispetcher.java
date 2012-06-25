package server.bin;

import eventmodel.EventsQueue;
import eventmodel.PlayListEventsProduser;
import eventmodel.ProtocolEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;

public class ProtocolEventDispetcher extends Thread
{   private String comm;
    private String args;

    private PlayListEventsProduser evprod = null;
    private final EventsQueue EVQUE = EventsQueue.getInstance();
    
    public ProtocolEventDispetcher() {
        evprod = new PlayListEventsProduser();
    }

    @Override
    public void run() {
        
        while (true) {
            
            ProtocolEvent ev = EVQUE.fetchEvent();
            
            if(ev!=null){
                
                try{
                    // Parse EventMeassage
                    comm = parseCommand(ev.getMessage());                
                    args = ev.getMessage().substring(comm.length()+1).trim();
                    ev.setMessage(args);
                    
                    switch(comm){
                        case "connectme": evprod.doConnectPlayer(ev);
                            break;
                        case "refresh"  : evprod.doRefreshLst(ev);
                            break;
                        case "suggest"  : evprod.doSuggest(ev);
                            break;
                        case "response" : evprod.doResponse(ev);
                            break;
                        case "out" : evprod.doOut(ev);
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
        private String parseCommand(String type) throws StringIndexOutOfBoundsException{
            String comm = type.substring(0,type.indexOf(':'));
            return comm;
	}
    
}
