package forageria.metier;

import forageria.metier.carte.Coordonnee;

/**
 * Stocker notre joueur.
 */
public class Joueur {
    /**
     * Stocke les coordonnées du joueur.
     */
    private Coordonnee coordonnee;


    /**
     * Constructeur de la classe Joueur.
     *
     *
     * @param coordonnee Ou se trouve notre joueur actuellement.
     */
    public Joueur(Coordonnee coordonnee){
        this.coordonnee = coordonnee;
    }


    /**
     * Assesseur de la variable coordonnee.
     *
     *
     * @return Coordonnées du joueur.
     */
    public Coordonnee getCoordonnee() {
        return coordonnee;
    }


    /**
     * Permet de déplacer notre joueur de mouvement.
     *
     *
     * @param mouvement Indique le sens du déplacement de notre joueur.
     */
    public void deplacer(TypeMouvement mouvement){
        this.coordonnee = coordonnee.getVoisin(mouvement);
    }
}
