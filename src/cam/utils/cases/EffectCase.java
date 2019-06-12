package cam.utils.cases;

import cam.utils.ihm.PlateauIHM;
import cam.utils.personnages.Personnage;

/**
 * Classe qui modelise l'ensemble des cases a effet
 * @author Adrien Bassail et Allan Boukhebza
 */
public abstract class EffectCase extends Case {


	/**
	 * Active l'effet sur une case du plateau donnée
	 * @param perso concerné par l'effet
	 * @param plateauIHM du jeu en cours
	 */
	public abstract void activeEffect(Personnage perso, PlateauIHM plateauIHM);

}
