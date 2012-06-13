package server.model;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

import server.model.Client;
import server.model.ClientList;
import server.model.NameAlredyExistException;

public class ClientListTest {
 
	@Test(expected=NameAlredyExistException.class)
	public void testSameName() throws NameAlredyExistException{
		ClientList lst = ClientList.getInstance();
		
		Client cl = new Client("Nick", new Scanner(""), null);
		
		lst.addClient(cl);
		System.out.println("11"+lst);
		lst.addClient(cl);

	}
	
	public void testRemoveName() throws NameAlredyExistException{
		ClientList lst = ClientList.getInstance();
		System.out.println("!!"+lst);
		if(lst.size()>0){
			lst.removeClient("Nick");
			lst.removeClient("Tom");
		}
		else{
			lst.addClient(new Client("Nick", new Scanner(""), null));
			lst.removeClient("Nick");
			lst.removeClient("Tom");
		}
		
		assertEquals(0, lst.size());

	}
}
