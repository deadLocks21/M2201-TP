package forageria.metier.carte;

/**
 * Classe en charge de stocker les coordonnées d'un point.
 * Il correspond au point de jonction entre une ligne et une colonne de la carte.
 */
public class Coordonnee {
    /**
     * Permet de stocker le ligne des coordonnées.
     */
    private int ligne;
    /**
     * Permet de stocker le colonne des coordonnées.
     */
    private int colonne;



    /**
     * Constructeur de la classe Coordonnées.
     *
     *
     * @param aLigne    Ligne de nos co.
     * @param aColonne  Colonne de nos co.
     */
    public Coordonnee(int aLigne, int aColonne){
        this.ligne = aLigne;
        this.colonne = aColonne;
    }



    /**
     * Assesseur de la variable ligne
     *
     *
     * @return Numéro correspondant à la ligne.
     */
    public int getLigne() {
        return ligne;
    }

    /**
     * Assesseur de la variable colonne.
     *
     *
     * @return Numéro correspondant à la colonne.
     */
    public int getColonne() {
        return colonne;
    }
}
