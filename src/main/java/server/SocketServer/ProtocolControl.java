
package server.SocketServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import server.commands.LoginCommand;
import server.model.client.Client;
import server.model.client.ClientList;
import server.model.client.ClientSocket;
import server.model.client.NameAlredyExistException;

class ProtocolControl extends Thread {
    
    private final Client client;
    
    ProtocolControl(Client client) {
        this.client = client;
    }

    @Override
    public void run() {


            String inputData="";    String s=""; 

            while ((!(s=client.receive()).toLowerCase().equals("endcommand")))
            {
                    inputData += s;
            }

            System.out.println(">>"+inputData);

            CommandFactory.getInstance(inputData, client).execute();            	




        
    }
    
}
