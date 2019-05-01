package cam.utils.cases;

import cam.utils.personnages.Personnage;
import cam.utils.plateau.Plateau;

public interface IEffetCase {
	
	public void activeEffect(Personnage personnage, Plateau plateau);

}
