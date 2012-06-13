
package server.SocketSever;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import server.SocketSever.commands.LoginCommand;
import server.model.Client;
import server.model.ClientList;
import server.model.NameAlredyExistException;

class ProtocolControl extends Thread {
    private final Socket incoming;
    
    ProtocolControl(Socket accept) {
        incoming = accept;
    }

    @Override
    public void run() {

         try
         {
            InputStream  inStream  = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();
            Scanner in = new Scanner(inStream);
           
            Client client = new Client("", inStream, outStream);
           
            String s; String inputData="";
          
            while(in.hasNext()){
            	while (!(s = in.nextLine()).equals("endCommand")){
                	
                	inputData += s;
                }
            	//System.out.println(inputData);
            	
                CommandFactory.getInstance(s, client).execute();            	
            }
            

    
         }
         catch(IOException ex) {
                Logger.getLogger(ProtocolControl.class.getName()).log(Level.SEVERE, null, ex);
         }
         finally
         {
            try {
                incoming.close();
            } catch (IOException ex) {
                Logger.getLogger(ProtocolControl.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
    }
    
}
