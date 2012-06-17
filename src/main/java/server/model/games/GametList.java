package server.model.games;

import server.model.client.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GametList {
	
	private static GametList instance;
	private static List<AGame> lst = new LinkedList<AGame>();
	
	
	private GametList() {}
		
	public static synchronized GametList getInstance(){

		if( instance == null )		{
			instance = new GametList();		
		}
		return instance;
	}
	
	public void addGame(AGame game){
		
		lst.add(game);
		
	}
	
	public void removeGame(int i){
		
		lst.remove(i);
	}
	
	public int size(){
		return lst.size();
	}
	
	public AGame get(int i){
		return lst.get(i);
	}

	
	@Override
	public String toString() {
		return lst.toString();
	}
        
        public String toStringWithout(Client cl){
            
            StringBuilder bl = new StringBuilder();
            
            for (int i = 0; i < lst.size()-1; i++) {
                bl.append(lst.get(i).toString());
            }
            
            return bl.toString();
        }
	
	
}
