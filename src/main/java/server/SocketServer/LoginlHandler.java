
package server.SocketServer;

import eventmodel.EventsQueue;
import eventmodel.iProtocolListener;
import eventmodel.ProtocolEvent;
import java.awt.EventQueue;
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

class LoginlHandler extends Thread {
    
    private final Client client;
    
    LoginlHandler(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        
        // RECEIVE MESSAGE

            String inputData = client.receive();
            System.out.println(">>"+inputData);
            
            try
            {
                String comm = parseCommand(inputData);  
                if(comm.toLowerCase().equals("connectme"))
                {
                    ClientList lstClient = ClientList.getInstance();
                    lstClient.addClient(client);
                    EventsQueue.getInstance().putEvent(new ProtocolEvent(client,inputData));
                    //client.addProtocolListener();
                }

            }
            catch(StringIndexOutOfBoundsException e) {
                Logger.getLogger(LoginlHandler.class.getName()).log(Level.SEVERE, "My message________ : ", e);}
            catch (NameAlredyExistException e){
                client.send("ConnectFrameEventHandler_badName");
            }
            finally{
                client.send("endResponse");
            }
            
    }
    private String parseCommand(String type) throws StringIndexOutOfBoundsException{
            String comm = type.substring(0,type.indexOf(':'));
            return comm;
	}
    
}
