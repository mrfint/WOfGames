/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.commands;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import server.SocketSever.CommandFactory;
import server.model.client.Client;

public class SuggestGameCommandTest {
    
    @Test
    public void test() {
       Client c = new Client();
       c.setName("Vasia");
       
       SuggestGameCommand l = (SuggestGameCommand) CommandFactory.getInstance("SuggestGame: XO, Serg", c);

//        assertEquals("Vasia", l.getPlayer1());
//        assertEquals("Serg", l.getPlayer2());
//        assertEquals("XO", l.getGame());

    }
}
