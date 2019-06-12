package cam.utils.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Permet de creer un client pour une connexion reseau
 * @author allan
 */
public class Client implements Connexion {
	
    private Socket socket;
    
    private String address; 
    private int port;
    
    private PrintWriter writer;
    private BufferedReader reader;
    
    /**
     * @param address l'adresse ip de la machine a joindre <em>ex: 192.168.1.1</em>
     * @param port le port sur lequel communiquer
     * @throws UnknownHostException si le client est introuvable
     * @throws IOException si le client est introuvable donc rien a ecire au destinataire
     */
    public Client(String address, int port) throws UnknownHostException, IOException
    {
    	this.address = address;
    	this.port = port;
    	this.socket = new Socket(address, port);
    	
    	this.writer = new PrintWriter(this.socket.getOutputStream());
    	this.reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
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
    	this.socket.close();
    }
    
    public Socket getSocket() {
		return socket;
	}
    
    public String getAddress() {
		return address;
	}
    
    public int getPort() {
		return port;
	}

    public PrintWriter getWriter() {
		return writer;
	}
    
    public BufferedReader getReader() {
		return reader;
	}

	@Override
	public Socket getClientSocket() {
		return this.socket;
	}

	@Override
	public ServerSocket getServerSocket() {
		return null;
	}
}