package server.model.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Client {
	
	private String name;
	private Scanner  inStream;
	private PrintWriter outStream;
	
	
	
	public Client() {
	}

	public Client(String name, Scanner inputStream, PrintWriter oStream) {
		this.name = name;
		this.inStream = inputStream;
		this.outStream = oStream;
	}
	
	public Client(String name, InputStream inStream, OutputStream outStream) {
		this.name = name;		
		this.inStream = new Scanner(inStream);
		this.outStream = new PrintWriter(outStream, true);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Scanner getInputStream() {
		return inStream;
	}
	public void setInputStream(Scanner inputStream) {
		this.inStream = inputStream;
	}
	public PrintWriter getOutStream() {
		return outStream;
	}
	public void setOutStream(PrintWriter oStream) {
		this.outStream = oStream;
	}

	@Override
	public String toString() {
		return name + ";";
	}
	
	
}
