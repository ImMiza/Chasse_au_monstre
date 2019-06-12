package cam.utils.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cam.utils.ihm.CaseIHM;
import cam.utils.ihm.PlateauIHM;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Position;
import cam.utils.personnages.ia.RandomMonster;

public class TestRandomMonstre
{

	private RandomMonster monster;
	private PlateauIHM plateau;
	
	@Before
	public void before()
	{
		monster = new RandomMonster(0, 0, "Adrien");

		Chasseur chasseur = new Chasseur(0, 0, "");
		plateau = new PlateauIHM(monster, chasseur, initPlateau(10, 10));

	}
	
	private CaseIHM[][] initPlateau(int lig, int col) {
		CaseIHM[][] plateau = new CaseIHM[lig][col];
		
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[i].length; j++) {
				plateau[i][j] = new CaseIHM(i , j , 0, 0, 0, 0);
			}
		}
		return plateau;
	}

	@Test
	public void test()
	{
		while (!plateau.sontToutesVisitee() && !plateau.monstreBloquer())
		{
			Position pos = monster.ChoosePosition(plateau);
			plateau.deplacerMonstre(plateau.chercheCase(pos.getX(), pos.getY()));
		}
		
		assertTrue(plateau.sontToutesVisitee() || plateau.monstreBloquer());
	}

}
