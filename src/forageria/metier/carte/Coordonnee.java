package forageria.metier.carte;

import forageria.metier.TypeMouvement;

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

    /**
     * Détermine les coordonnées du voisin demandé avec mouvement de notre case.
     *
     *
     * @param mouvement  Mouvement souhaité.
     * @return Coordonnées en fonction du mouvement souhaité.
     */
    public Coordonnee getVoisin(TypeMouvement mouvement){
        Coordonnee c = null;

        switch (mouvement){
            case TOP:
                c = new Coordonnee(ligne - 1, colonne);
                break;
            case RIGHT:
                c = new Coordonnee(ligne, colonne + 1);
                break;
            case BOTTOM:
                c = new Coordonnee(ligne + 1, colonne);
                break;
            case LEFT:
                c = new Coordonnee(ligne, colonne - 1);
                break;
        }

        return c;
    }

    /**
     * Renvoie le mouvement à réaliser pour passer de la Coordonnee courante à la Coordonnee destination.
     *
     *
     * @param destination Destination de là ou l'on veut se rendre
     *
     * @return Mouvement pour effectuer le déplacement.
     */
    public TypeMouvement getMouvementPourAller(Coordonnee destination){
        TypeMouvement mvt = null;
        int dLigne = destination.getLigne() - ligne;
        int dColonne = destination.getColonne() - colonne;

        if(dLigne < 0 && dColonne == 0)
            mvt = TypeMouvement.TOP;

        if(dLigne == 0 && dColonne > 0)
            mvt = TypeMouvement.RIGHT;

        if(dLigne > 0 && dColonne == 0)
            mvt = TypeMouvement.BOTTOM;

        if(dLigne == 0 && dColonne < 0)
            mvt = TypeMouvement.LEFT;

        return mvt;
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

    @Override
    public String toString(){
        return "(" + this.colonne + ", " + this.ligne + ")";
    }
}
