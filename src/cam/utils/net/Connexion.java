package cam.utils.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Utiliser pour creer des classes reseaux pour permettre une connexion a distance
 * @author allan
 */
public interface Connexion {

	/**
	 * Permet d'ecrire un message a une personne distante
	 * @param message le message en question
	 * @throws IOException si aucun destinataire
	 */
	public void write(String message) throws IOException;
    
	/**
	 * Permet de lire un message d'une personne distante
	 * @throws IOException si lier a aucun destinataire
	 * @return le message recu
	 */
    public String read() throws IOException;
    
    /**
     * Permet de fermer la communication distante
     * @throws IOException si y'a rien a close
     */
    public void close() throws IOException;
    
    /**
     * @return le client de la connexion
     */
    public Socket getClientSocket();
    
    /**
     * @return le serveur de la connexion
     */
    public ServerSocket getServerSocket();
}
