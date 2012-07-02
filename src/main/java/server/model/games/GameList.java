package server.model.games;

import server.model.client.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GameList {
	
	private static GameList instance;
	private static HashMap<Integer, Game> lst = new HashMap<Integer, Game>();
	
	
	private GameList() {}
		
	public static synchronized GameList getInstance(){

		if( instance == null )		{
			instance = new GameList();		
		}
		return instance;
	}
	
	public void addGame(Game game){
		

		
	}
	
	public void removeGame(int i){
		
		lst.remove(i);
	}
	
	public int size(){
		return lst.size();
	}
	
	public Game get(int i){
		return lst.get(i);
	}

	@Override
	public String toString() {
		return lst.toString();
	}
        
       
	public void remove (Game game){
            lst.remove(game.getId());
        }

	
}
