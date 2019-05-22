package cam.utils.net;

import java.io.IOException;

public class TestClient {

	public static void main(String[] args) {

		try {
			Client client = new Client("192.168.43.149", 5007);

			Thread output = new Thread(new OutputListener(client));
			Thread input = new Thread(new InputListener(client));
			
			output.start();
			input.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
