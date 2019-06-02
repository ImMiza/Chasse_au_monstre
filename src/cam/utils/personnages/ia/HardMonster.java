package cam.utils.personnages.ia;

import java.util.ArrayList;
import java.util.List;

import cam.utils.cases.Case;
import cam.utils.personnages.Position;
import cam.utils.plateau.Plateau;

public class HardMonster extends MonstreIA{

	public HardMonster(Position p, String nom) {
		super(p, nom);
	}
	
	public HardMonster(int x, int y, String nom) {
		super(x, y, nom);
	}

	@Override
	public Position ChoosePosition(Plateau plateau) {
		boolean end = false;
		Position posChasseur = getPosition();
		
		while(!end) {
			List<Position> posPossibles = new ArrayList<Position>();
			List<Case> casePossibles = plateau.deplacementsPossible();
			
			for(int j=0 ; j<casePossibles.size() ; j++) {
				posPossibles.add(casePossibles.get(j).getPosition());
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
