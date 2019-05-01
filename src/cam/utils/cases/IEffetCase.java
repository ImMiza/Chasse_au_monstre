package cam.utils.cases;

import cam.utils.personnages.Personnage;
import cam.utils.plateau.Plateau;

/**
 * Cree une interfarce qui permet de regrouper les différentes cases à effet
 * @author Adrien BASSAIL
 */

public interface IEffetCase {
	
	/**
	 * Active la case à effet 
	 * @param personnage : Personnage qui est affecté par l'effet de la case
	 * @param plateau    : Plateau de la partie
	 */
	public void activeEffect(Personnage personnage, Plateau plateau);

}
