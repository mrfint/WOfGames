package server.SocketSever;

import server.commands.SuggestGameCommand;
import server.commands.LoginCommand;
import server.commands.ResponseCommand;
import server.model.Client;

public class CommandFactory {

	public static iCommand getInstance(String type, Client client){
		
		iCommand res = null;
		
		String comm = parseCommand(type);
		String args = type.substring(comm.length()+1).trim();
		
		if(comm.equals("ConnectMe"))		{
			res = new LoginCommand(args, client);
		}
		if(comm.equals("SuggestGame"))		{
			res = new SuggestGameCommand(args, client);
		}
                if(comm.equals("Response"))		{
			res = new ResponseCommand(args, client);
		}
                
		return res;
	}
	
	private static String parseCommand(String type){
        String comm = type.substring(0,type.indexOf(':'));
        return comm;
	}

}
