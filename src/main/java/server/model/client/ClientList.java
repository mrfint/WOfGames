package server.model.client;

import java.util.ArrayList;
import java.util.List;

public class ClientList {
	
	private static ClientList instance;
	private static List<Client> lst = new ArrayList<Client>();
	
	
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
			lst.add(c);
		}
		else{
			throw new NameAlredyExistException();
		}
		
	}
	
	public void removeClient(String name){
		
		Client c = find(name);
		
		if(c!=null){ 
			lst.remove(find(name));
		}
	}
	
	public int size(){
		return lst.size();
	}
	
	public Client get(String name){
		return find(name);
	}

	private Client find(String name) {
		Client res = null;
		for(Client c: lst)
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
		return lst.toString();
	}
        
        public String toStringWithout(Client cl){
            
            StringBuilder bl = new StringBuilder();
            
            for (int i = 0; i < lst.size(); i++) {
                bl.append(lst.get(i).toString());
            }
            
            return bl.toString();
        }
	
	
}
