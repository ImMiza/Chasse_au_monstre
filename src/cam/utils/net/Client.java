package cam.utils.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Connexion {
	
    private Socket socket;
    
    private String address; 
    private int port;
    
    private PrintWriter writer;
    private BufferedReader reader;
    
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