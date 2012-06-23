/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.commands;

import java.util.Scanner;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import server.SocketServer.CommandFactory;
import server.SocketServer.SocketListener;
import server.model.client.Client;


public class LoginCommandTest {
    
   
   
   @Test
    public void test() {
        Client s = new Client();
        LoginCommand l = (LoginCommand) CommandFactory.getInstance("ConnectMe: Vasia", s);

        assertEquals("Vasia", s.getName());

        s = new Client();
        l = (LoginCommand) CommandFactory.getInstance("ConnectMe: Vasia2", s);
        assertEquals("Vasia2", s.getName());
    }
}
