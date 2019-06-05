package cam.utils.ihm.menu.events;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class PierreFeuilleCiseauxEvent {
    /**
     * 1 = Pierre
     * 2 = Feuille
     * 3 = Ciseaux
     */
    private int choixMonstre;
    private int choixChasseur ;

    /**
     * Setter de choixChasseur
     * @param choixChasseur
     */
    public void setChoixChasseur(int choixChasseur) {
        this.choixChasseur = choixChasseur;
    }

    /**
     * Setter de choixMonstre
     * @param choixMonstre
     */
    public void setChoixMonstre(int choixMonstre) {
        this.choixMonstre = choixMonstre;
    }

    /**
     * Getter de choixChasseur
     * @return
     */
    public int getChoixChasseur() {
        return choixChasseur;
    }

    /**
     * Getter de choixMonstre
     * @return
     */
    public int getChoixMonstre() {
        return choixMonstre;
    }

    /**
     * Donne le resultat du pierre feuille ciseaux
     * @return -1 si le monstre gagne
     *  0 si il y a une egalite
     *  1 si le chasseur a gagne
     */
    public int getResult(){
        if (choixChasseur == 1) {
            if(choixMonstre == 1) return 0;
            else if(choixMonstre == 2) return -1;
            else return 1;
        } else if (choixChasseur == 2){
            if (choixMonstre == 1) return 1;
            else if (choixMonstre == 2) return 0;
            else return -1;
        } else {
            if (choixMonstre == 1) return -1;
            else if (choixMonstre == 2) return 1;
            else return 0;
        }
    }

    @FXML
    private Button btnCiseaux;

    @FXML
    private Button btnPierre;

    @FXML
    private Button btnFeuille;

    @FXML
    void pierreChoix(MouseEvent event) {
    	System.out.println("Pierre");

    }

    @FXML
    void feuilleChoix(MouseEvent event) {
    	System.out.println("Feuille");
    }

    @FXML
    void ciseauxChoix(MouseEvent event) {
    	System.out.println("Ciseaux");
    }
}
