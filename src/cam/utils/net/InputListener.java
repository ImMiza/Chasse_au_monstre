package cam.utils.net;

import java.io.IOException;

/**
 * Permet de recevoir un message de la connexion distante a tout moment grace au multi-Threading
 * @author allan
 */
public class InputListener implements Runnable{

	private Connexion connexion;
	
	public InputListener(Connexion connexion) {
		this.connexion = connexion;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				String s = connexion.read();
				System.out.println(s);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
