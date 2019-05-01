package cam.utils.cases;

import cam.utils.personnages.Personnage;

/**
 * Cases permettant au monstre de se téléporter entre deux cases tp 
 * La case sera visible par le monstre lors de son tour
 * Le monstre, une fois sur cette case pourra se déplacer sur une autre cas teleporteur
 * A VOIR ? UNE TELEPORT CASE NE SERAIT PAS FORCEMENT UNE CASE SUR LAQUELLE LE MONSTRE DOIT PASSER 
 * POUR FAIRE GAGNER LE MONSTRE
 * @author Adrien BASSAIL
 *
 */

public class TeleportCase extends Case  implements IEffetCase {

	
	@Override
	public void activeEffect(Personnage personnage) {
		// TODO
		
	}

}
