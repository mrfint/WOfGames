
package protocolcontrol;

import eventmodel.EventOfProtocol;
import java.util.LinkedList;
import java.util.List;
import server.model.client.ClientList;
import server.model.client.NameAlredyExistException;
import server.model.games.Game;
import server.model.games.GameList;
import server.model.games.X0game;


public class LobbyListEvMngr extends ProtocolEventMngr{
   
    public void doConnectPlayer(EventOfProtocol ev) {
       
        ProtocolListenerClient client = (ProtocolListenerClient)ev.getSource();
        
        // **************************varefy name
        String name = ev.getMessage();
        if(find(name)==null){ 
           
           // *******************************Do naming of client
           client.setName(ev.getMessage()); 
           
           addProtocolListener( client );
           
           // ******************************FireAllPlayers
           firePlayersList(ev);           
           
           // ******************************Add to general list of listeners
           ClientList.getInstance().addClient( client );

        }else{
            
           client.send("ConnectFrameEventHandler._badName\r\nendResponse");
        }
        
    }
    
    public void doSuggest(EventOfProtocol ev) {
        
        String[] q = ev.getMessage().split(",");
       
        String game          = q[0].trim();
        String suggestToName = q[1].trim();
        
        String suggestFrom   = ((ProtocolListenerClient)ev.getSource()).getName();
        
        ProtocolListenerClient playerTo = find(suggestToName);

        message = "SuggestGame:" + game + ","+ suggestFrom+"\r\nendResponse";
        playerTo.send(message);
        
    }
    
     public void doResponse(EventOfProtocol ev) {
        
        String[] q = ev.getMessage().split(",");
         
        String game           = q[0].trim();
        String responseToName = q[1].trim();
        String response       = q[2].trim();
        
        ProtocolListenerClient playerTo   = find(responseToName);
        ProtocolListenerClient playerFrom = (ProtocolListenerClient) ev.getSource();
        
        String responseFrom   = playerFrom.getName();

        
        if(playerTo.getState()==ProtocolListenerClient.BUSY)
        // ********************************************Player is BUSY or logout
        {
           message = "Response: "+game+","+playerTo+","+"reject\r\nendResponse";
           playerFrom.send(message);
        }
        else
        // ********************************************Player is free
        {
           message = "Response: "+game+","+playerTo+","+"accept\r\nendResponse";

//**************************************************** Can uncomment/comment          
//           removeProtocolListener(playerTo  );
//           removeProtocolListener(playerFrom);
           Game g = new X0game();
           
           GameList.getInstance().addGame(g);
           
        }
        
        playerTo.send(message);

    }

    public void doOut(EventOfProtocol ev) {
        ProtocolListenerClient client = (ProtocolListenerClient)ev.getSource();

        removeProtocolListener( client );
         // ******************************Add to general list of listeners
        ClientList.getInstance().removeClient(client);
        
        firePlayersList(ev);                // ***************fireAllPlayers
       
    }
}
