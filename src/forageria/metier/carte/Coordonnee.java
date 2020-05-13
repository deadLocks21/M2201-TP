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
     * @param ligne    Ligne de nos co.
     * @param colonne  Colonne de nos co.
     */
    public Coordonnee(int ligne, int colonne){
        this.ligne = ligne;
        this.colonne = colonne;
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



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.ligne;
        hash = 97 * hash + this.colonne;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordonnee other = (Coordonnee) obj;
        if (this.ligne != other.ligne) {
            return false;
        }
        if (this.colonne != other.colonne) {
            return false;
        }
        return true;
    }
}
