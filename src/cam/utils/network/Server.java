package cam.utils.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket server;
	private Client client;
	
	private PrintWriter writer;
	private Reader reader;
	
	public Server() throws IOException {
		this.server = new ServerSocket(0, 1, InetAddress.getLocalHost());
	}
	
	public Server(int port) throws IOException {
		this.server = new ServerSocket(port, 1, InetAddress.getLocalHost());
	}

	public Server(int port, InetAddress inetAdress) throws IOException {
		this.server = new ServerSocket(port, 1, inetAdress);
	}

	public Client receive() throws IOException {
		Socket s = this.server.accept();
		this.writer = new PrintWriter(s.getOutputStream());
		return new Client(s);
	}
	
	public void close() throws IOException {
		this.server.close();
	}
	
	public ServerSocket getServerSocket() {
		return server;
	}
	
	public Client getClient() {
		return client;
	}
	
	public boolean hasClientConnected() {
		return client != null && client.isConnected();
	}
	
	public boolean sendMessage(String message) {
		if(writer == null)
			return false;
		
		this.writer.print(message);
		this.writer.flush();
		return true;
	}
}
