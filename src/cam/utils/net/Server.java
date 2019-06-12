package cam.utils.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Permet de creer un serveur pour une connexion reseau
 * @author allan
 */
public class Server implements Connexion{

	private Socket client;
    private ServerSocket server;
    
    private byte[] clientAddress;
    private byte[] serverAddress; 
    private int port;
    
    private PrintWriter writer;
    private BufferedReader reader;
    
    public Server(int port) throws IOException {
    	this.server = new ServerSocket(port);
    	this.serverAddress = this.server.getInetAddress().getAddress();
    	this.port = port;
    }
    
    /**
     * Permet de mettre "sur ecoute" le reseau sur laquelle se trouve le serveur pour voir si justement
     * un client n'essaierais pas de se connecter
     * @throws IOException si il y a rien a ecouter car null ou autre...
     */
    public void listen() throws IOException {
    	this.client = this.server.accept();
    	this.clientAddress = this.client.getInetAddress().getAddress();
    	this.writer = new PrintWriter(this.client.getOutputStream());
    	this.reader = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
    }
    
    @Override
    public void write(String message) throws IOException {
        this.writer.println(message);
        this.writer.flush();
    }
    
    @Override
    public String read() throws IOException {
    	String s = reader.readLine();
    	return s;
    }
    
    @Override
    public void close() throws IOException {
    	this.server.close();
    	this.client.close();
    }
    
    public Socket getClient() {
		return client;
	}
    
    public byte[] getClientAddress() {
		return clientAddress;
	}
    
    public ServerSocket getServer() {
		return server;
	}
    
    public byte[] getServerAddress() {
		return serverAddress;
	}
    
    public PrintWriter getWriter() {
		return writer;
	}
    
    public BufferedReader getReader() {
		return reader;
	}
    
    public int getPort() {
		return port;
	}

	@Override
	public Socket getClientSocket() {
		return this.client;
	}

	@Override
	public ServerSocket getServerSocket() {
		return this.server;
	}
}
