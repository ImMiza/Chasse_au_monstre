package junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cam.utils.ihm.CaseIHM;
import cam.utils.ihm.PlateauIHM;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;
import cam.utils.personnages.Position;

public class TestPlateau
{

	private static PlateauIHM	p;
	private static Monstre		m;
	private static Chasseur		c;
	private static CaseIHM[][]	cases;

	@Before
	public void before()
	{
		m = new Monstre(0, 0, "monstre");
		c = new Chasseur(6, 4, "chasseur");
		cases = new CaseIHM[10][10];
		for (int i = 0; i < cases.length; i++)
		{
			for (int j = 0; j < cases[i].length; j++)
			{
				cases[i][j] = new CaseIHM(i, j, 0, 0, 0, 0);
			}
		}
		p = new PlateauIHM(m, c, cases);
	}

	@Test
	public void testDeplacerMonstre()
	{
		assertTrue(p.deplacerMonstre(cases[0][1]));
		
		Position pos = new Position(0, 1);
		assertEquals(p.getMonstre().getPosition().getX(), pos.getX());
		assertEquals(p.getMonstre().getPosition().getY(), pos.getY());
		
		assertTrue(p.deplacerMonstre(cases[1][1]));
		assertNotEquals(p.getMonstre().getPosition().getX(), pos.getX());
		
		assertFalse(p.deplacerMonstre(cases[5][5]));
	}

}
