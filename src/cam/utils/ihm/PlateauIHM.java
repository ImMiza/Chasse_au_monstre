package cam.utils.ihm;

import java.util.ArrayList;
import java.util.List;

import cam.utils.cases.Case;
import cam.utils.cases.EffectCase;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;
import cam.utils.personnages.Position;

public class PlateauIHM {
	/**
	 * Classe qui détermine le fonctionnement du plateau de jeu
	 * @author Hugo Wieder et Aymeric Defossez et Boukhebza Allan
	 */
	 
	// ATTRIBUTS
	private Monstre monstre;
	private Chasseur chasseur;
	private CaseIHM[][] plateau;
	
	private Position chasseurPositionLast;
	private Position monstrePositionLast;
	
	// CONSTRUCTEURS
	/**
	 * Constructeur d'une instance de Plateau
	 * @param monstre
	 * @param chasseur
	 * @param nbLignes
	 * @param nbColonnes
	 */
	public PlateauIHM(Monstre monstre, Chasseur chasseur, CaseIHM[][] cases) {
		this.monstre = monstre;
		this.chasseur = chasseur;
		this.plateau = cases;
	}
	
	/**
	 * permet de deplacer le monstre
	 * @param uneCase case de destination du monstre
	 * @return true si réussite ou false si echec
	 */
	public boolean deplacerMonstre(CaseIHM uneCase) {
		List<CaseIHM> deplacement = deplacementsPossible();
		if (deplacement.contains(uneCase)) {
			chercheCase(monstre.getPosition().getX(), monstre.getPosition().getY()).getCase().setVisited();
			chercheCase(monstre.getPosition().getX(), monstre.getPosition().getY()).getCase().setTourVisited(1);
			
			this.monstrePositionLast = this.monstre.getPosition().clone();
			
			int[] c = this.chercheCase(uneCase);
			this.monstre.getPosition().setX(c[0]);
			this.monstre.getPosition().setY(c[1]);
			
			if(this.plateau[this.monstre.getPosition().getX()][this.monstre.getPosition().getY()].getCase() instanceof EffectCase) {
				((EffectCase) this.plateau[this.monstre.getPosition().getX()][this.monstre.getPosition().getY()].getCase()).activeEffect(monstre, this);
				MainController.writeConsole("OH NON, le monstre est aller sur une case de ralentissement !");
			}
			
			return true;
		}
		return false;
	}
	
	public void deplacerChasseur(Case uneCase) {
		this.chasseurPositionLast = this.chasseur.getPosition().clone();
		this.chasseur.getPosition().setX(uneCase.getPosition().getX());
		this.chasseur.getPosition().setY(uneCase.getPosition().getY());
	}
	
	
	/**
	 * retourne le plateau de jeu
	 * @return le plateau de jeu
	 */
	public CaseIHM[][] getPlateau() {
		return plateau;
	}
	
	// METHODES
	/**
	 * Renvoie la liste de toutes les cases où le déplacement est possible en partant de la case mise en paramètre
	 * @param caseDeDepart
	 * @return uneListe
	 */
	public List<CaseIHM> deplacementsPossible(){
		CaseIHM caseDeDepart = chercheCase(this.monstre.getPosition().getX(), this.monstre.getPosition().getY());
		ArrayList<CaseIHM> res = new ArrayList<CaseIHM>();
		int[] coordonneesCase = this.chercheCase(caseDeDepart);
		if (coordonneesCase == null) return null;
		int i = coordonneesCase[0], j = coordonneesCase[1];
		
		res.addAll(deplacementDiagonale(i, j));
		res.addAll(deplacementVertical(i,j));
		res.addAll(deplacementHorizontal(i, j));
		
		while(!sontToutesLibres(res)) {
			boolean trouvee = false; int k = 0;
			while (!trouvee && k<res.size()) {
				if(res.get(k).getCase().isVisited()) {
					trouvee=true;
					res.remove(k);
				}
				k++;
			}
		}
		return res;
	}
	
	/**
	 * Verifie que toutes les cases de maListe n'ont jamais etees visitees par le monstre
	 * @param maListe
	 * @return 
	 */
	private boolean sontToutesLibres(List<CaseIHM> maListe) {
		for (int i = 0; i< maListe.size(); i++) {
			if(maListe.get(i).getCase().isVisited()) return false;
		}
		return true;
	}
	
	/**
	 * retourne si le monstre a visite toutes les case
	 * @return true si toutes les cases sont visite et false le cas echeant
	 */
	public boolean sontToutesVisitee() {
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[i].length; j++) {
				if (!plateau[i][j].getCase().isVisited()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean monstreBloquer() {
		return deplacementsPossible().isEmpty();
	}
	
	/**
	 * Verifie l'appartenance d'une case au plateau
	 * @param ligne
	 * @param colonne
	 * @return Boolean true si la case d'indice [ligne][colonne] appartient au plateau
	 */
	public boolean appartientAuPlateau(int ligne, int colonne) {
		return (ligne>=0 && ligne <this.plateau.length) && (colonne >=0 && colonne < this.plateau[0].length);
	}
	
	/**
	 * permet d ajouter a une liste donnee la case de coordonnee donnee
	 * @param uneListe la liste a remplire
	 * @param ligne de la case a ajouter
	 * @param colonne de la case a ajouter
	 */
	private void ajoute(List<CaseIHM> uneListe, int ligne, int colonne) {
		if (appartientAuPlateau(ligne, colonne)) {
			uneListe.add(this.chercheCase(ligne, colonne));
		}
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return Renvoie tous les deplacements diagonnaux possibles
	 */
	private List<CaseIHM> deplacementDiagonale(int ligne, int colonne){
		List<CaseIHM> maListe = new ArrayList<CaseIHM>();
		ajoute(maListe, ligne + this.monstre.getDeplacementDiagonal(), colonne + this.monstre.getDeplacementDiagonal());
		ajoute(maListe, ligne + this.monstre.getDeplacementDiagonal(), colonne - this.monstre.getDeplacementDiagonal());
		ajoute(maListe, ligne - this.monstre.getDeplacementDiagonal(), colonne + this.monstre.getDeplacementDiagonal());
		ajoute(maListe, ligne - this.monstre.getDeplacementDiagonal(), colonne - this.monstre.getDeplacementDiagonal());
		return maListe;
	}
	/**7
	 * 
	 * @param i
	 * @param j
	 * @return Renvoie tous les deplacements Verticaux possibles
	 */
	private List<CaseIHM> deplacementVertical(int ligne, int colonne){
		List<CaseIHM> maListe = new ArrayList<CaseIHM>();
		for (int i = 0; i<this.monstre.getDeplacementVertical(); i++) {
			ajoute(maListe, ligne + i+1, colonne);
			ajoute(maListe, ligne - (i+1), colonne);
		}
		return maListe;
	}
	/**
	 * 
	 * @param i
	 * @param j
	 * @return Renvoie tous les deplacements horizontaux possibles
	 */
	private List<CaseIHM> deplacementHorizontal(int ligne, int colonne){
		List<CaseIHM> maListe = new ArrayList<CaseIHM>();
		for (int i = 0; i<this.monstre.getDeplacementHorizontal(); i++) {
			ajoute(maListe, ligne, colonne + i+1);
			ajoute(maListe, ligne, colonne - (i+1));
		}
		
		return maListe;
	}
	
	/**
	 * Methode privee permettant de renvoyer les coordonnees de la case mise en parametre
	 * @exception Renvoie null si la case n'appartient pas au plateau
	 * @param uneCase
	 * @return coordonnees
	 */
	private int[] chercheCase(CaseIHM uneCase) {
		for (int i = 0; i<this.plateau.length; i++) {
			for (int j=0; j<this.plateau[0].length; j++) {
				if(this.plateau[i][j].getCase().equals(uneCase.getCase())) {
					return new int[] {i, j};
				}
			}
		}
		return null;
	}
	
	/**
	 * Methode privee permettant de renvoyer la case de coordonees rentrees en parametre
	 * @exception renvoie null si les coordonnees ne sont pas valides(n'appartiennent pas au plateau)
	 * @param i
	 * @param j
	 * @return
	 */
	public CaseIHM chercheCase(int i, int j) {
		if((i<this.plateau.length && j<this.plateau[0].length) && (i>=0 && j>=0)) {
			return this.plateau[i][j];
		}
		return null;
	}

	public Monstre getMonstre()
	{
		return monstre;
	}

	public void setMonstre(Monstre monstre)
	{
		this.monstre = monstre;
	}

	public Chasseur getChasseur()
	{
		return chasseur;
	}

	public void setChasseur(Chasseur chasseur)
	{
		this.chasseur = chasseur;
	}

	public void setPlateau(CaseIHM[][] plateau)
	{
		this.plateau = plateau;
	}

	public Position getChasseurPositionLast()
	{
		return chasseurPositionLast;
	}

	public Position getMonstrePositionLast()
	{
		return monstrePositionLast;
	}

}
