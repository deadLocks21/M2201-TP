package forageria.modules.etats;

import forageria.metier.TypeMouvement;
import forageria.metier.algorithmes.Dijkstra;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.cases.Case;
import forageria.modules.ModuleDecision;

import java.util.ArrayList;

/**
 * Cherche le site idéal pour une forge.
 */
public class EtatTrouverSiteForge extends Etat {
    /**
     * Stocke le chemin jusqu'au fourneau.
     */
    private ArrayList<TypeMouvement> chemin;
    /**
     * Algo de Dijsktra.
     */
    private Dijkstra dijkstra;


    /**
     * Constructeur d'un EtatTrouverSiteForge.
     *
     * @param module Valeur de la variable module.
     */
    public EtatTrouverSiteForge(ModuleDecision module) {
        super(module);

        chemin = null;
        dijkstra = null;
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
        return chemin == null ?
                new EtatAttendre(getModule()) :
                new EtatSeDeplacer(getModule(), chemin);
    }

    @Override
    public void action() {
        Carte carte = getMemoire().getCarte();
        int coutMin = 1;
        Case zoneRetenue = null;

        dijkstra = new Dijkstra(carte);
        dijkstra.calculerDistancesDepuis(getMemoire().getCaseJoueur());

        for (Case c : carte.getCases()){
            if (carte.estZoneValide(c)){
                int cout = coutZone(c);

                if (zoneRetenue == null || cout < coutMin){
                    coutMin = cout;
                    zoneRetenue = c;
                }
            }
        }

        chemin = dijkstra.getChemin(zoneRetenue);
        getMemoire().setSiteForge(zoneRetenue.getCoordonnee());
    }
}
