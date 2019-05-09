package cam.utils.cases;

import cam.utils.personnages.Personnage;
import cam.utils.plateau.Plateau;

public abstract class EffectCase extends Case {
	
	public abstract void activeEffect(Personnage perso, Plateau pl);

}
