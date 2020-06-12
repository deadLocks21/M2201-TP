package forageria.modules.etats;

import forageria.metier.TypeMouvement;
import forageria.metier.algorithmes.Dijkstra;
import forageria.metier.carte.Coordonnee;
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
     * Permet de connaitre le cout pour aller et déblayer une zone.
     *
     *
     * @param coinBasGauche  Case qui sert de référence à la zone.
     *
     * @return Cout pour s'y rendre et la déblayer.
     */
    private int coutZone(Case coinBasGauche){
        int cout = dijkstra.getDistance(coinBasGauche);

        for(int i=0; i<2; i++) {
            for(int j=0; j<2; j++) {
                if(i !=0 || j !=0) {
                    Coordonnee coordonnee = coinBasGauche.getCoordonnee();
                    Case position = this.getMemoire().getCarte().getCase(new Coordonnee(coordonnee.getLigne()-i,coordonnee.getColonne()+j));
                    if(position.getRessource() != null) {
                        cout += position.getRessource().nombreCoupsPioche();
                    }
                }
            }
        }

        return cout;
    }


    @Override
    public Etat transition() {
        return null;
    }

    @Override
    public void action() {

    }
}
