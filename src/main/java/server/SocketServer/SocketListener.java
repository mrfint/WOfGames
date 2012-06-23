package server.SocketServer;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.model.client.Client;
import server.model.client.ClientSocket;


public class SocketListener implements Runnable
{  
    private ServerSocket s = null;
    
    @Override
    public void run() {
     
        try 
        {
            // establish server socket
            s = new ServerSocket(8189);
        
            while (true) {
                Client client = new ClientSocket(s.accept());
                Thread t= new LoginlHandler(client);
                
                t.start();
            }
            
       } catch (IOException ex) 
       {
            Logger.getLogger(SocketListener.class.getName()).log(Level.SEVERE, null, ex);
       }
       
        
    }
    
}


