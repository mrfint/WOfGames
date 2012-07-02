package server.model.client;

import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jetty.websocket.WebSocket;

import server.eventmodel.EventOfProtocol;
import server.protocolcontrol.ProtocolListenerClient;

public class WebSocketClient extends ProtocolListenerClient
			implements WebSocket.OnTextMessage {

	private LinkedList<String> messageQueue = null;
	private Connection connection = null;

	@Override
	public EventOfProtocol receive() {
		EventOfProtocol event = new EventOfProtocol(this, messageQueue.pop());
		return event;
	}

	@Override
	public boolean hasIncoming() {
		return !messageQueue.isEmpty();
	}

	@Override
	public void send(String ev) {
		try {
			connection.sendMessage(ev);
		} catch (IOException e) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, e);
		}
	}

	@Override
	public void onClose(int arg0, String arg1) {
		/* nothing to do here yet */
	}

	@Override
	public void onOpen(Connection conn) {
		this.connection = conn;
	}

	@Override
	public void onMessage(String mess) {
		messageQueue.add(mess);
	}

}
