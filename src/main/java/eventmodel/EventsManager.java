
package eventmodel;

import java.util.LinkedList;
import java.util.List;
import server.model.client.Client;
import server.model.client.ClientList;
import server.model.games.Game;
import server.model.games.X0game;


public class EventsManager extends Thread{
    private List<iProtocolListener> listeners = new LinkedList<iProtocolListener>();
    
    public void addMyListener(iProtocolListener listener)
    {
        listeners.add(listener);
    }
    public iProtocolListener[] getMyListeners()
    {
        return listeners.toArray(new iProtocolListener[listeners.size()]);
    }
  
    public void removeMyListener(iProtocolListener listener)
    {
        listeners.remove(listener);
    }

    public void doRefresh(ProtocolEvent ev) {
        
       for(iProtocolListener listener : listeners)
            listener.refresh(ev);
    }
    
    public void doSuggest(ProtocolEvent ev) {
        
        String[] q = ev.getMessage().split(",");
        
        String suggestToName = q[1].trim();
        
        for(iProtocolListener listener : listeners){
            String name = ((Client)listener).getName();
            if(suggestToName.equals(name)){
                listener.suggest(ev);
                break;
            }
        }
    }
    
     public void doResponse(ProtocolEvent ev) {
        
        String[] q = ev.getMessage().split(",");
        
        String responseToName = q[1].trim();
        
        for(iProtocolListener listener : listeners){
            String name = ((Client)listener).getName();
            if(responseToName.equals(name)){
                listener.response(ev);
                break;
            }
        }
    }
}
