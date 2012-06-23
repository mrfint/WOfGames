package server.SocketSever;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import server.SocketServer.CommandFactory;
import server.commands.LoginCommand;
import server.commands.ResponseGameCommand;
import server.commands.SuggestGameCommand;
import server.commands.iCommand;
import server.model.client.Client;

@RunWith(Parameterized.class)
public class CommandFactoryTest {
        private String args;
	private String comm;
	
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
				{ "ConnectMe:", "LoginCommand" },
				{ "SuggestGame:", "SuggestGameCommand" },
				{ "Response:", "ResponseCommand" },
				{ "bye", "NullCommand" },
                                { "bye:", "NullCommand" }
//                                { "mock", "DS_Mock" },
				};
		return Arrays.asList(data);
	}
	
	public CommandFactoryTest(String comm, String ds) {
		this.args = comm;
		this.comm = ds;
	}
	
	@Test
	public void test() {
		iCommand command = CommandFactory.getInstance(args+"vasdd, sdfd", new Client());
		assertEquals(comm, command == null ? null : command.getClass().getSimpleName());
	}

    

}
