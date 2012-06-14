package server.model;

import java.util.ArrayList;
import java.util.List;

public class ClientList {
	
	private static ClientList instance;
	private static List<Client> lstClient = new ArrayList<Client>();
	
	
	private ClientList() {}
		
	public static synchronized ClientList getInstance(){

		if( instance == null )		{
			instance = new ClientList();		
		}
		return instance;
	}
	
	public void addClient(Client c) throws NameAlredyExistException{
		
		Client tmp = find(c.getName());
		
		if(tmp==null){
			lstClient.add(c);
		}
		else{
			throw new NameAlredyExistException();
		}
		
	}
	
	public void removeClient(String name){
		
		Client c = find(name);
		
		if(c!=null){ 
			lstClient.remove(find(name));
		}
	}
	
	public int size(){
		return lstClient.size();
	}
	
	public Client get(String name){
		return null;
	}

	private Client find(String name) {
		Client res = null;
		for(Client c: lstClient)
		{
			if(c.getName().equals(name))
			{
				res = c;
				break;
			}
			
		}
		
		return res;
	}
	
	@Override
	public String toString() {
		return lstClient.toString();
	}
	
	
}
