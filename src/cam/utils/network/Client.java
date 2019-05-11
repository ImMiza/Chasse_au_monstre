package cam.utils.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	private Socket client;

	public Client(int port) throws IOException {
		this.client = new Socket(InetAddress.getLocalHost(), port);
	}
	
	public Client(InetAddress inetAdress, int port) throws IOException {
		this.client = new Socket(inetAdress, port);
	}
	
	public Client(Socket socket) {
		this.client = socket;
	}

	public void close() throws IOException {
		this.client.close();
	}
	
	public boolean isConnected() {
		return this.client.isConnected();
	}
	
	public Socket getSocket() {
		return client;
	}
	
	
}
