package eventmodel;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;
import server.commands.NullCommand;

public class ProtocolEventDispetcher extends Thread
{   private String comm;
    private EventsProduser evprod = null;
    private final EventsQueue EVQUE = EventsQueue.getInstance();
    
    public ProtocolEventDispetcher() {
        evprod = new EventsProduser();
    }

    @Override
    public void run() {
        
        while (true) {
            
            ProtocolEvent ev = EVQUE.fetchEvent();
            
            if(ev!=null){
                
                try{
                    comm = parseCommand(ev.getMessage());                
                
                
                    switch(comm){
                        case "refresh" : evprod.doRefreshLst(ev);
                            break;
                        case "suggest" : evprod.doSuggest(ev);
                            break;
                        case "response" : evprod.doResponse(ev);
                            break;
                        default: {};
                    }
                
                }
                catch(StringIndexOutOfBoundsException e){ }
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
