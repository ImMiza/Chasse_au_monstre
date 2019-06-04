package cam.utils.personnages.ia;

import cam.utils.ihm.PlateauIHM;
import cam.utils.personnages.Position;

public abstract interface IA{

	public abstract Position ChoosePosition(PlateauIHM plateau);
	
}
