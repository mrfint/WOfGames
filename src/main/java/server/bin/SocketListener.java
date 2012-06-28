package server.bin;

import eventmodel.EventsQueue;
import eventmodel.EventOfProtocol;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import protocolcontrol.ProtocolListenerClient;
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
        
            while (true) 
            {
                ProtocolListenerClient client = new ClientSocket(s.accept());
                
                EventOfProtocol authorization  = client.receive();
                
                EventsQueue.getInstance().putEvent( authorization );

            }
            
       } catch (IOException ex) 
       {
            Logger.getLogger(SocketListener.class.getName()).log(Level.SEVERE, null, ex);
       }
       
        
    }
    
}


