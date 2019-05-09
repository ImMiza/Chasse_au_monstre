package cam.utils.cases;

import cam.utils.personnages.Monstre;
import cam.utils.personnages.Personnage;
import cam.utils.plateau.Plateau;


/**
 * Crée une case qui ralentit le chasseur (diminue ses déplacements possibles)
 * @author Adrien BASSAIL
 */

public class SlowCase extends EffectCase{

	@Override
	public void activeEffect(Personnage perso, Plateau pl) {
		if (perso instanceof Monstre) {
			Monstre m = (Monstre) perso;
			
			m.setDeplacementDiagonal(0);
			m.setDeplacementHorizontal(1);
			m.setDeplacementVertical(1);
		}
		
	}

	
}
