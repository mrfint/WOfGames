
package protocolcontrol;

import eventmodel.EventOfProtocol;
import java.util.LinkedList;
import java.util.List;
import server.model.client.ClientList;
import server.model.client.NameAlredyExistException;
import server.model.games.Game;
import server.model.games.X0game;


abstract public class ProtocolEventMngr{
    
    protected List<ProtocolListenerClient> listeners = new LinkedList<ProtocolListenerClient>();
    protected String message;
    
    abstract public void doSuggest(EventOfProtocol ev);
    
    abstract public void doResponse(EventOfProtocol ev);

    abstract public void doOut(EventOfProtocol ev);
    
    abstract public void doConnectPlayer(EventOfProtocol ev);

    public void addProtocolListener(ProtocolListenerClient listener){
         listeners.add(listener);
    }
    
    public ProtocolListenerClient getByName(String name){      
        return find(name);       
    }

    protected ProtocolListenerClient find(String name) {
            ProtocolListenerClient res = null;
            for(ProtocolListenerClient c: listeners)
            {
                    if(c.getName().equals(name))
                    {
                            res = c;
                            break;
                    }
            }

            return res;
    }
   
  
    public void removeProtocolListener(ProtocolListenerClient listener)
    {
        listeners.remove(listener);
    }
    

    public void firePlayersList(EventOfProtocol ev) {
        
        // Build message
        StringBuilder playerList = new StringBuilder();
        for(ProtocolListenerClient listener : listeners){
            //HAVE TO INSSERT     WITHOUT    SELF
            playerList.append(listener.getName()).append(",");  // MOCK
        }
        
        String message = "_playerList\r\n"+playerList+"\r\nendResponse";
  
        for(ProtocolListenerClient listener : listeners){
            listener.send(message);
        }
    }
    
    public void doNothing(EventOfProtocol ev) {
        ProtocolListenerClient client = (ProtocolListenerClient)ev.getSource();
        client.send("_badCommand: \r\nendResponse");
    }
}
