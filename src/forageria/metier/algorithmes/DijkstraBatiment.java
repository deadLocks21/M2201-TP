package forageria.metier.algorithmes;

import forageria.metier.carte.Carte;
import forageria.metier.carte.TypeBatiment;

/**
 * Dijkstra pour les batiment.
 */
public class DijkstraBatiment extends Dijkstra {
    /**
     * Type du batiment que l'on recherche.
     */
    TypeBatiment typeBatiment;
    

    /**
     * Constructur de la classe.
     *
     * @param carte Représente la carte stocké par la classe.
     */
    public DijkstraBatiment(Carte carte, TypeBatiment typeBatiment) {
        super(carte);

        this.typeBatiment = typeBatiment;
    }
}
