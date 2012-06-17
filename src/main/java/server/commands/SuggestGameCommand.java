
package server.commands;

import server.model.client.Client;
import server.model.client.ClientList;
import server.model.games.AGame;
import server.model.games.GameList;
import server.model.games.X0game;


public class SuggestGameCommand implements iCommand {
    private String game;
    private Client player1;
    private Client player2;
    
    
    public SuggestGameCommand(String args, Client client) {
        
        player1 = client;
        String[] q = args.split(",");
        game = q[0].trim();
        player2 = ClientList.getInstance().get( q[1].trim() );
        
    }
    
    @Override
    public void execute() {
        
        ClientList lstClient = ClientList.getInstance();
        GameList  lstGames  = GameList.getInstance();
        
        AGame game = new X0game(player1);       // insert there factory of games
        
        lstGames.addGame(game);
        
        player2.getOutStream().println("SuggestGame:" + game + ","+ player1.getName()+","+game.getId());      
        player2.getOutStream().println("endResponse");
        
        
    }
    
}
