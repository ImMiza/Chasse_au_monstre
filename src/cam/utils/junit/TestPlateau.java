package cam.utils.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import cam.utils.ihm.CaseIHM;
import cam.utils.ihm.PlateauIHM;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;

class TestPlateau {

	private static PlateauIHM p;
	private static Monstre m;
	private static Chasseur c;
	private static CaseIHM[][] cases;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		m = new Monstre(2, 2, "monstre");
		c = new Chasseur(6, 4, "chasseur");
		cases = new CaseIHM[10][10];
		for (int i = 0; i < cases.length; i++) {
			for (int j = 0; j < cases[i].length; j++) {
				cases[i][j] = new CaseIHM(i, j, 50 * i, 50 * j, 50, 50);
			}
		}
		p = new PlateauIHM(m , c, cases);
	}

	@Test
	void testDeplacerMonstre() {
		assertEquals(p.getMonstre(), m);
	}

}
