package cam.utils.net;

import java.io.IOException;

public class TestClient {

	public static void main(String[] args) {

		try {
			Client client = new Client("10.194.247.223", 5006);

			Thread output = new Thread(new OutputListener(client));
			Thread input = new Thread(new InputListener(client));
			
			output.start();
			input.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
