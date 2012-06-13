
package server.SocketSever.commands;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import server.SocketSever.iCommand;
import server.model.Client;
import server.model.ClientList;
import server.model.NameAlredyExistException;


public class LoginCommand implements iCommand{
	
	private String arg;
	private Client client;

	public LoginCommand(String arg, Client client) {
		this.arg = arg;
		this.client = client;
	}

	@Override
	public void execute() {
		
		ClientList lstClient = ClientList.getInstance();
		
		try {
        	
			lstClient.addClient(client);
			
			client.getOutStream().println(lstClient.toString() + ": endResponse" );
					
		} catch (NameAlredyExistException e) {
			
			client.getOutStream().println("badName : endResponse");
			
		}
		
	}
    
   
    
}
