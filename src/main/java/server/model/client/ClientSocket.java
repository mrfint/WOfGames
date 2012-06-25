package server.model.client;

import eventmodel.ProtocolEvent;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientSocket extends Client{
        
        BufferedReader br = null;
	PrintWriter    pw = null;

        public ClientSocket() {
        }

        
	public ClientSocket(Socket socket) {
            try {
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                pw = new PrintWriter(socket.getOutputStream(), true);

            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        @Override
	public void send(String message) {
		pw.println(message);
	}
        @Override
	public ProtocolEvent receive(){
        
            ProtocolEvent res = new ProtocolEvent(this, "");
            
            try {
                res.setMessage( br.readLine() );
            } catch (IOException ex) {
                Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return res;
            
	}
        
        @Override
	public boolean hasIncoming(){
		
            boolean res = false;
            
            try {
                
                res = br.ready();
                
            } catch (IOException ex) {
                Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return res;
                
	}

   
	
}
