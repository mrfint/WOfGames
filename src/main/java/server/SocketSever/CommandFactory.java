package server.SocketSever;

import server.commands.*;
import server.model.client.Client;

public class CommandFactory {

	public static iCommand getInstance(String type, Client client){
		
		iCommand res = new NullCommand();
		String comm = "";   String args = "";
                
                try{
                    comm = parseCommand(type);                
                    args = type.substring(comm.length()+1).trim();
                }
                catch(StringIndexOutOfBoundsException e){
                    res = new NullCommand();
                }
		
		
		if(comm.equals("ConnectMe"))            {
                    res = new LoginCommand(args, client);
		}
                
		if(comm.equals("SuggestGame"))		{
                    res = new SuggestGameCommand(args, client);
		}
                if(comm.equals("Response"))		{
                    res = new ResponseCommand(args, client);
		}
                
		return res ;
	}
	
	private static String parseCommand(String type) throws StringIndexOutOfBoundsException{
            String comm = type.substring(0,type.indexOf(':'));
            return comm;
	}

}
