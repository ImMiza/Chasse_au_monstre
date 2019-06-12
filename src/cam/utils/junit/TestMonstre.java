package cam.utils.junit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import cam.utils.personnages.Monstre;

class TestMonstre {

	private static Monstre m;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		m = new Monstre(3, 7, "monstre");
	}

	@Test
	void test() {
		
	}

}
