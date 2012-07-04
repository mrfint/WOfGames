package server.bin;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketHandler;

import server.model.client.WebSocketClient;

public class WebSocketListener implements Runnable {

	private static final int PORT = 8190;
	@Override
	public void run() {
		try {
			Server server = new Server(PORT);
			ConnMan coman = new ConnMan();
			coman.setHandler(new DefaultHandler());
			server.setHandler(coman);
			server.start();
            Logger.getLogger(WebSocketListener.class
            		.getName()).log(Level.SEVERE, null,
            				"Websocket listener started.");
		} catch (Exception e) {}
	}

	private class ConnMan extends WebSocketHandler {

		@Override
		public WebSocket doWebSocketConnect(HttpServletRequest request,
				String protocol) {
			return new WebSocketClient();
		}
		
	}
}
