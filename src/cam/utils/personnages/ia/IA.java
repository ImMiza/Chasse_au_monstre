package cam.utils.personnages.ia;

import cam.utils.personnages.Position;
import cam.utils.plateau.Plateau;

public abstract interface IA{

	public abstract Position ChoosePosition(Plateau plateau);
	
}
