package server.SocketSever;

import static org.junit.Assert.*;

import org.junit.Test;

import server.SocketSever.CommandFactory;
import server.model.Client;

public class CommandFactoryTest {

	@Test
	public void test() {
		CommandFactory.getInstance("Response: Accept/Refuse : EndCommand", new Client());
	}

}
