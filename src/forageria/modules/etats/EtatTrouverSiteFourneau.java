package forageria.modules.etats;

import forageria.metier.TypeMouvement;
import forageria.metier.algorithmes.Dijkstra;
import forageria.metier.carte.cases.Case;
import forageria.modules.ModuleDecision;

import java.util.ArrayList;

/**
 * Etat qui cherche ou se trouve le site du fourneau.
 */
public class EtatTrouverSiteFourneau extends Etat {
    /**
     * Stocke le chemin jusqu'au fourneau.
     */
    private ArrayList<TypeMouvement> chemin;
    /**
     * Algo de Dijsktra.
     */
    private Dijkstra dijkstra;
    // TODO Initialiser

    /**
     * Constructeur d'un EtatTrouverSiteFourneau.
     *
     * @param module Valeur de la variable module.
     */
    public EtatTrouverSiteFourneau(ModuleDecision module) {
        super(module);
    }


    /**
     * TODO Doc
     * @param coinBasGauche
     * @return
     */
    private int coutZone(Case coinBasGauche){
        return 0; // TODO Implémenter.
    }


    @Override
    public Etat transition() {
        return null;
    }

    @Override
    public void action() {

    }
}
