package cam.utils.cases;

import cam.utils.ihm.PlateauIHM;
import cam.utils.personnages.Personnage;

public abstract class EffectCase extends Case {
	
	public abstract void activeEffect(Personnage perso, PlateauIHM plateauIHM);

}
