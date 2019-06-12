package cam.utils.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cam.main.games.PierreFeuilleCiseaux;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;

public class TestPierreFeuilleCiseaux
{
	
	private Chasseur joueur1;
	private Monstre joueur2;
	
	PierreFeuilleCiseaux game;
	
	@Before
	public void before() {
		joueur1 = new Chasseur(0, 0, "Allan");
		joueur2 = new Monstre(0, 0, "Adrien");
		
		game = new PierreFeuilleCiseaux(joueur1, joueur2);
	}

	@Test
	public void testHasGagnant() {
		assertFalse(game.hasWinner());
		assertEquals(game.getWinner(), null);
	}
	
	@Test
	public void testHasGagnant2() {
		game.startGame();
		assertTrue(game.hasWinner());
		assertNotEquals(game.getWinner(), null);
	}
	
}
