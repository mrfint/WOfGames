
package eventmodel;

import java.util.LinkedList;
import java.util.List;
import server.model.client.Client;
import server.model.client.ClientList;
import server.model.client.NameAlredyExistException;
import server.model.games.Game;
import server.model.games.X0game;


public class EventsProduser{
    private List<iProtocolListener> listeners = new LinkedList<iProtocolListener>();
    
    public void addProtocolListener(iProtocolListener listener)throws NameAlredyExistException{
		
        iProtocolListener tmp = find(listener.getName());

        if(tmp==null){
                listeners.add(listener);
        }
        else{
                throw new NameAlredyExistException();
        }
    }
    public iProtocolListener getByName(String name){
        
        return find(name);
        
    }

    private iProtocolListener find(String name) {
            iProtocolListener res = null;
            for(iProtocolListener c: listeners)
            {
                    if(c.getName().equals(name))
                    {
                            res = c;
                            break;
                    }
            }

            return res;
    }
    public iProtocolListener[] getMyListeners()
    {
        return listeners.toArray(new iProtocolListener[listeners.size()]);
    }
  
    public void removeMyListener(iProtocolListener listener)
    {
        listeners.remove(listener);
    }
    
    public void doConnectPlayer(ProtocolEvent ev) {
       
        iProtocolListener client = (iProtocolListener)ev.getSource();
        
        try{
           addProtocolListener( client );
           // fireAllPlayers
           doRefreshLst(ev);
        }
        catch(NameAlredyExistException e){
           client.send("ConnectFrameEventHandler._badName\r\n endResponse");
       }
        
    }

    public void doRefreshLst(ProtocolEvent ev) {
        
        // Build message
        StringBuilder playerList = new StringBuilder();
        for(iProtocolListener listener : listeners){
            //HAVE TO INSSERT     WITHOUT    SELF
            playerList.append(listener.getName()).append(",");  // MOCK
        }
        
        String message = "_playerList\r\n"+playerList+"\r\nendResponse";
  
        for(iProtocolListener listener : listeners){
            listener.send(message);
        }
    }
    
    public void doSuggest(ProtocolEvent ev) {
        
        String args = ev.getMessage();
        args = args.substring(args.indexOf(":")).trim();
        String[] q = args.split(",");
       
        String game = q[0].trim();
        String suggestToName = q[1].trim();
        String suggestFrom = ((Client)ev.getSource()).getName();
        
        String message = "SuggestGame:" + game + ","+ suggestFrom;
        
        ProtocolEvent event = new ProtocolEvent(message);
        
        for(iProtocolListener listener : listeners){
            String name = ((Client)listener).getName();
            if(suggestToName.equals(name)){
                listener.suggest(event);
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
