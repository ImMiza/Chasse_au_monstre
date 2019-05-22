package cam.utils.tests;

import java.io.IOException;
import java.util.Arrays;

import cam.utils.net.InputListener;
import cam.utils.net.OutputListener;
import cam.utils.net.Server;

public class TestServeur {

	public static void main(String[] args) {

		try {
<<<<<<< HEAD
			Server server = new Server(5007);
			server.listen();
			
			System.out.println("connecte");
=======
			Server server = new Server(5006);
			server.listen();
			
			System.out.println("Client connecté");
>>>>>>> d49b95843b1efc1d67f50a208ef43044f039f2ae
			Thread output = new Thread(new OutputListener(server));
			Thread input = new Thread(new InputListener(server));
			
			output.start();
			input.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
