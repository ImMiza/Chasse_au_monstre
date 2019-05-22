package cam.utils.tests;

import java.io.IOException;

import cam.utils.net.InputListener;
import cam.utils.net.OutputListener;
import cam.utils.net.Server;

public class TestServeur {

	public static void main(String[] args) {

		try {
			Server server = new Server(5007);
			server.listen();
			
			System.out.println("connecte");
			Thread output = new Thread(new OutputListener(server));
			Thread input = new Thread(new InputListener(server));
			
			output.start();
			input.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
