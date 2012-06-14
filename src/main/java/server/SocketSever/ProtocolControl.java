
package server.SocketSever;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import server.commands.LoginCommand;
import server.model.Client;
import server.model.ClientList;
import server.model.NameAlredyExistException;

class ProtocolControl extends Thread {
    private final Socket incoming;
    
    ProtocolControl(Socket incoming) {
        this.incoming = incoming;
    }

    @Override
    public void run() {

         try
         {
            InputStream  inStream  = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();
            Scanner in = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
           
            //out.println("Hello");
            Client client = new Client("", inStream, outStream);   

           
            
          
            while(in.hasNextLine())
            {
            	String inputData="";    String s=""; 
                
                while (in.hasNextLine())
                {
                        s = in.nextLine();
                	System.out.println("s  :  "+s);
                	
                        if (s.equals("endCommand"))  break;
                        inputData += s;
                }
                CommandFactory.getInstance(inputData, client).execute();            	
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
         System.out.println("Enddd");
  
    }
    
}
