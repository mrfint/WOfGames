package server.model.client;

import protocolcontrol.ProtocolListenerClient;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class ClientList {
	
	private static ClientList instance;
	private static List<ProtocolListenerClient> lst = new LinkedList<ProtocolListenerClient>();
	
	
	private ClientList() {}
		
	public static synchronized ClientList getInstance(){

		if( instance == null )		{
			instance = new ClientList();		
		}
		return instance;
	}
	
	public void addClient(ProtocolListenerClient c){

                lst.add(c);

	}
	
	public void removeClient(ProtocolListenerClient c){
		lst.remove(c);
	}
	
	public int size(){
		return lst.size();
	}
	
	@Override
	public String toString() {
		return lst.toString();
        }

        public ProtocolListenerClient get(int i) {
            return lst.get(i);
        }
	
	
}
