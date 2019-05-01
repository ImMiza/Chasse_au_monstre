package cam.utils.cases;

import cam.utils.personnages.Monstre;
import cam.utils.personnages.Personnage;

/**
 * Case de piège, le(s) pièges sont posés au début de la partie par le chasseur
 * Une case de piège ralentit le monstre quand il passe dessus
 * @author Adrien BASSAIL
 *
 */

public class TrapCase extends Case implements IEffetCase{

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
			
			System.out.println("Monstre ralenti par un piège du chasseur !");
		}
	}
}