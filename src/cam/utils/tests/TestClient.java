package cam.utils.tests;

import java.io.IOException;

import cam.utils.net.Client;
import cam.utils.net.InputListener;
import cam.utils.net.OutputListener;

public class TestClient {

	public static void main(String[] args) {

		try {
<<<<<<< HEAD
			Client client = new Client("10.21.63.235", 5006);
=======
			Client client = new Client("192.168.43.26", 5006);
>>>>>>> d49b95843b1efc1d67f50a208ef43044f039f2ae

			Thread output = new Thread(new OutputListener(client));
			Thread input = new Thread(new InputListener(client));
			
			output.start();
			input.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
