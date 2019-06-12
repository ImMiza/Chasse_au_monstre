package cam.utils.net;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Permet d'envoyer un message a la connexion distante a tout moment grace au multi-Threading
 * @author allan
 */
public class OutputListener implements Runnable{

	private Connexion connexion;
	private Scanner sc;
	
	public OutputListener(Connexion connexion) {
		this(connexion, System.in);
	}
	
	public OutputListener(Connexion connexion, InputStream input) {
		this.connexion = connexion;
		this.sc = new Scanner(input);
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				String message = this.sc.nextLine();
				this.connexion.write(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
