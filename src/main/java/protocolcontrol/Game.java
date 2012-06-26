
package protocolcontrol;

import eventmodel.EventOfProtocol;
import java.util.LinkedList;
import server.model.client.ClientList;
import server.model.client.NameAlredyExistException;
import server.model.games.GameList;
import server.model.games.X0game;


public class Game extends ProtocolEventMngr{
    public static int counter = 0;

    protected int current = -1;
    private int id;
    
    public Game(){
        
        id = server.model.games.Game.counter++;

    }
    
    public void doConnectPlayer(EventOfProtocol ev) {
       
        ProtocolListenerClient client = (ProtocolListenerClient)ev.getSource();
        
        addProtocolListener( client );
        client.setState(ProtocolListenerClient.BUSY);
        
        
        firePlayersList(ev);                // ***************fireAllPlayers
        
    }

    
    
    public void doSuggest(EventOfProtocol ev) {
    
    }
    
    public void doResponse(EventOfProtocol ev) {
        
    }

    public void doOut(EventOfProtocol ev) {
        
        ProtocolListenerClient client = (ProtocolListenerClient)ev.getSource();

        removeProtocolListener( client );
        
        firePlayersList(ev);                // ***************fireAllPlayers
       
    }

    public void doNext(EventOfProtocol ev) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
