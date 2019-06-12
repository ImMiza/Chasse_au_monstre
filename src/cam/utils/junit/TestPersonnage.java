package cam.utils.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import cam.utils.personnages.Personnage;

class TestPersonnage {

	private static Personnage p;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		p = new Personnage(2, 5, "test");
	}

	@Test
	void testNom1() {
		assertEquals(p.getNom(), "test");
	}

	@Test
	void testNom2() {
		p.setNom("nouveau test");
		assertEquals(p.getNom(), "nouveau test");
	}
	
	@Test
	void testPosition1() {
		assertEquals(p.getPosition().getX(), 2);
		assertEquals(p.getPosition().getY(), 5);
	}
	
	@Test
	void testPosition2() {
		p.setX(6);
		p.setY(3);
		assertEquals(p.getPosition().getX(), 6);
		assertEquals(p.getPosition().getY(), 3);
	}
	
}
