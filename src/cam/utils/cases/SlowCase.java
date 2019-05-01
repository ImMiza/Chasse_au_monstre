package cam.utils.cases;

import cam.utils.personnages.Monstre;
import cam.utils.personnages.Personnage;


/**
 * Crée une case qui ralentit le chasseur
 * @author Adrien BASSAIL
 *
 */

public class SlowCase extends Case implements IEffetCase{

	/**
	 * Active l'effet de personnage ralenti
	 * @param monstre à ralentir
	 */
	public void activeEffect(Personnage personnage) {
		if(personnage instanceof Monstre) {
			Monstre monster = (Monstre) personnage;
			monster.setDeplacementDiagonal(1);
			monster.setDeplacementHorizontal(1);
			monster.setDeplacementVertical(1);
			
			System.out.println("Monstre ralenti par une case slow !");
		}
	}
}