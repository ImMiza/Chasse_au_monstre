package cam.utils.tests;

import java.io.IOException;

import cam.utils.net.Client;
import cam.utils.net.InputListener;
import cam.utils.net.OutputListener;

public class TestClient {

	public static void main(String[] args) {

		try {
			Client client = new Client("10.21.63.235", 5006);

			Thread output = new Thread(new OutputListener(client));
			Thread input = new Thread(new InputListener(client));
			
			output.start();
			input.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
