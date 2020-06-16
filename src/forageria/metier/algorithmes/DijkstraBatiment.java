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
        int ret = super.getInfini();

        if(destination.getType() != TypeCase.EAU && (destination.getBatiment() == null || typeBatiment == destination.getBatiment()))
            ret = destination.getRessource() != null ? destination.getRessource().nombreCoupsPioche() + 1 : 1;

        return ret;
    }
}
