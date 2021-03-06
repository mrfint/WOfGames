
package server.commands;

import server.model.client.Client;
import server.model.client.ClientList;
import server.model.games.Game;
import server.model.games.X0game;


public class SuggestGameCommand implements iCommand {
    private String game;
    private Client player1;
    private Client player2;
    
    
    public SuggestGameCommand(String args, Client client) throws ArrayIndexOutOfBoundsException {
        
        player1 = client;
        String[] q = args.split(",");
        
        game = q[0].trim();
        player2 = ClientList.getInstance().getByName( q[1].trim() );
    
    }
    
    @Override
    public void execute() {
        
        ClientList lstClient = ClientList.getInstance();
        
        Game game = new X0game(player1);       // insert there factory of games
        
        //lstGames.addGame(game);
        
        player2.send("SuggestGame:" + game + ","+ player1.getName()+","+game.getId());      
        player2.send("endResponse");
        
        
    }
    
}
