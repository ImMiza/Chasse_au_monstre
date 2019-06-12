package junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cam.utils.personnages.Personnage;

public class TestPersonnage
{

	private static Personnage p;
	
	@Before
	public void setUpBeforeClass() {
		p = new Personnage(2, 5, "test");
	}

	@Test
	public void testNom1() {
		assertEquals(p.getNom(), "test");
	}

	@Test
	public void testNom2() {
		p.setNom("nouveau test");
		assertEquals(p.getNom(), "nouveau test");
	}
	
	@Test
	public void testPosition1() {
		assertEquals(p.getPosition().getX(), 2);
		assertEquals(p.getPosition().getY(), 5);
	}
	
	@Test
	public void testPosition2() {
		p.setX(6);
		p.setY(3);
		assertEquals(p.getPosition().getX(), 6);
		assertEquals(p.getPosition().getY(), 3);
	}

}
