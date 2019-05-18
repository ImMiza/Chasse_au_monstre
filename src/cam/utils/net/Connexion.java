package cam.utils.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public interface Connexion {

	public void write(String message) throws IOException;
    
    public String read() throws IOException;
    
    public void close() throws IOException;
    
    public Socket getClientSocket();
    
    public ServerSocket getServerSocket();
}
