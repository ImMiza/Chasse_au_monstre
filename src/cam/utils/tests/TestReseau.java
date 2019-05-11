package cam.utils.tests;

import java.io.IOException;

import cam.utils.network.Server;

public class TestReseau {

	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.receive();
	
		
		server.close();
	}
}
