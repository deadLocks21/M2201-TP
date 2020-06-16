package forageria.metier.algorithmes;

import forageria.metier.carte.Carte;
import forageria.metier.carte.TypeBatiment;
import forageria.metier.carte.cases.Case;
import forageria.metier.carte.cases.TypeCase;

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


    @Override
    protected int coutMouvementVers(Case destination){
        int ret = 1;

        if (destination.getType() == TypeCase.EAU || (destination.getBatiment() != null && destination.getBatiment() != this.typeBatiment) ) {
            ret = this.getInfini();
        } else if (destination.getRessource() != null) {
            ret = 1 + destination.getRessource().nombreCoupsPioche();
        }

        return ret;
    }
}
