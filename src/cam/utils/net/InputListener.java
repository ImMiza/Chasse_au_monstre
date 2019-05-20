package cam.utils.net;

import java.io.IOException;

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
