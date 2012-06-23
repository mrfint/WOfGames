
package server.commands;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import server.model.client.Client;
import server.model.client.ClientList;
import server.model.client.NameAlredyExistException;


public class LoginCommand implements iCommand{
	
	private String arg;
	private Client client;

	public LoginCommand(String arg, Client client) {
            this.arg = arg;
            this.client = client;
            client.setName(arg);
	}

	@Override
	public void execute() {
		
            ClientList lstClient = ClientList.getInstance();
            
            try {

                lstClient.addClient(client);
                
                client.send("_playerList");

                client.send(lstClient.toStringWithout(client));

            } catch (NameAlredyExistException e) {

                client.send("ConnectFrameEventHandler_badName");

            }

            client.send("endResponse");
	}
    
}
