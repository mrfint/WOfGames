
package server.commands;

import server.model.client.Client;
import server.model.client.ClientList;
import server.model.games.AGame;
import server.model.games.GameListOld;


public class ResponseGameCommand implements iCommand {
    private String game;
    private Client player1;
    private Client player2;
    private final int idGame;
    
    
    public ResponseGameCommand(String args, Client client) {
        
        player2 = client;
        String[] q = args.split(",");
        game = q[0].trim();
        player1 = ClientList.getInstance().get( q[1].trim() );
        idGame = Integer.parseInt(q[2].trim());
    }
    
    @Override
    public void execute() {
        
        ClientList lstClient = ClientList.getInstance();
        
        GameListOld lstGame = GameListOld.getInstance();
        
        AGame game = lstGame.get(idGame);
        if(player1.getState()==Client.BUSY)
        {
           lstGame.remove(game); 
           player2.getOutStream().println("Fail");
           player2.getOutStream().println("endResponse");
        }
        else{
           player1.setState(Client.BUSY);
           player2.setState(Client.BUSY);
           
           game.start();
           
        }
    }
    
}
