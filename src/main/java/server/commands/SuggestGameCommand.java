
package server.commands;

import server.SocketSever.iCommand;
import server.model.Client;
import server.model.ClientList;


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
        
        player2.getOutStream().println("SuggestGame:" + game + ","+ player1.getName());      
        player2.getOutStream().println("endResponse");
        
        
    }
    
}
