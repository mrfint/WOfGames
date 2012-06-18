/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model;

import server.model.client.NameAlredyExistException;
import server.model.client.ClientList;
import server.model.client.Client;
import java.util.Scanner;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author nick
 */
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
//			lst.removeClient("Nick");
//			lst.removeClient("Tom");
		}
		else{
			lst.addClient(new Client("Nick", new Scanner(""), null));
//			lst.removeClient("Nick");
//			lst.removeClient("Tom");
		}
		
		assertEquals(0, lst.size());

	}
}
