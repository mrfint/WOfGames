/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.commands;

import server.SocketSever.iCommand;
import server.model.Client;


public class SuggestGameCommand implements iCommand {
    private String game;
    private String player1;
    private String player2;
    
    
    public SuggestGameCommand(String args, Client client) {
        player1 = client.getName();
        String[] q = args.split(",");
        game = q[0].trim();
        player2 = q[1].trim();
    }
    
    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getGame() {
        return game;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }
    
}
