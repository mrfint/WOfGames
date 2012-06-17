package server.model.games;

import server.model.client.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameList {
	
	private static GameList instance;
	private static List<AGame> lst = new LinkedList<AGame>();
	
	
	private GameList() {}
		
	public static synchronized GameList getInstance(){

		if( instance == null )		{
			instance = new GameList();		
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
		return lst.get( getByID(i) );
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

        public int getByID(int id) {
            int res = -1;
            for (int i = 0; i < size(); i++) 
            {
                if(lst.get(i).getId()==id )
                {
                    res = i;
                    break;
                }
                
            }
            
            return res;
        }
	public void remove (AGame game){
            lst.remove(game);
        }

	
}
