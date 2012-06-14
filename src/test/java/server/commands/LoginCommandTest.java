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
import server.SocketSever.CommandFactory;
import server.SocketSever.SocketListener;
import server.model.Client;
import sun.misc.Cleaner;


public class LoginCommandTest {
    
   
   
   @Test
    public void test() {
        LoginCommand l = (LoginCommand) CommandFactory.getInstance("ConnectMe: Vasia", new Client());

        assertEquals("Vasia", l.getArg());

        l = (LoginCommand) CommandFactory.getInstance("ConnectMe: Vasia2", new Client());
        assertEquals("Vasia2", l.getArg());
    }
}
