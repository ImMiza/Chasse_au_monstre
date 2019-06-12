package cam.utils.personnages.ia;

/**
 * Classe qui gère une IA plus complexe pour le Monstre
 * @author Adrien Bassail
 */

import java.util.ArrayList;
import java.util.List;

import cam.utils.ihm.CaseIHM;
import cam.utils.ihm.PlateauIHM;
import cam.utils.personnages.Position;

public class HardMonster extends MonstreIA{

	public HardMonster(Position p, String nom) {
		super(p, nom);
	}
	
	public HardMonster(int x, int y, String nom) {
		super(x, y, nom);
	}

	@Override
	/**
	 * Choisit la position suivante du monstre selon un paterne sur la carte,
	 * le patterne fonctionne sur toute carte carrée rectangle, ou autre
	 */
	public Position ChoosePosition(PlateauIHM plateau) {
		boolean end = false;
		Position posChasseur = getPosition();
		
		while(!end) {
			List<Position> posPossibles = new ArrayList<Position>();
			List<CaseIHM> casePossibles = plateau.deplacementsPossible();
			
			for(int j=0 ; j<casePossibles.size() ; j++) {
				posPossibles.add(casePossibles.get(j).getCase().getPosition());
			}
			
			//POSSIBILITE DE JOUER AVEC LES COORDONNEES POUR FAIRE DES PATTERNES DIFFERENTS (a reflechir pour ia normale)
			if(posPossibles.contains(new Position(posChasseur.getX()-1, posChasseur.getY()))) {
				Position res = new Position(posChasseur.getX()-1, posChasseur.getY());
				return res;
			}
			
			else if(posPossibles.contains(new Position(posChasseur.getX(), posChasseur.getY()-1))) {
				Position res = new Position(posChasseur.getX(), posChasseur.getY()-1);
				return res;
			}
			
			else if(posPossibles.contains(new Position(posChasseur.getX()+1, posChasseur.getY()))) {
				Position res = new Position(posChasseur.getX()+1, posChasseur.getY());
				return res;
			}
			
			else if(posPossibles.contains(new Position(posChasseur.getX(), posChasseur.getY()+1))) {
				Position res = new Position(posChasseur.getX(), posChasseur.getY()+1);
				return res;
			}

			end = true;
		}
		
		
		
		
		return null;
	}
	
	

	

}
