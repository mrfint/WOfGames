package server.model.client;

import eventmodel.iProtocolListener;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class ClientList {
	
	private static ClientList instance;
	private static List<iProtocolListener> lst = new LinkedList<iProtocolListener>();
	
	
	private ClientList() {}
		
	public static synchronized ClientList getInstance(){

		if( instance == null )		{
			instance = new ClientList();		
		}
		return instance;
	}
	
	public void addClient(iProtocolListener c){

                lst.add(c);

	}
	
	public void removeClient(iProtocolListener c){
		lst.remove(c);
	}
	
	public int size(){
		return lst.size();
	}
	
	@Override
	public String toString() {
		return lst.toString();
        }

        public iProtocolListener get(int i) {
            return lst.get(i);
        }
	
	
}
