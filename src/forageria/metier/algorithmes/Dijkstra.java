package forageria.metier.algorithmes;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.cases.Case;
import forageria.metier.carte.cases.CaseHerbe;
import forageria.metier.carte.cases.TypeCase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Dijkstra extends AlgorithmeCalculDistance {
    /**
     * Permet de savoir si une case a été visité.
     */
    private HashMap<Case, Boolean> estVisite;
    /**
     * Permet de connaitre le prédecesseur d'une case.
     */
    private HashMap<Case, Case> predecesseur;
    /**
     * Valeur attribué à l'infini.
     */
    private int infini;


    /**
     * Constructur de la classe.
     *
     * @param carte Représente la carte stocké par la classe.
     */
    public Dijkstra(Carte carte) {
        super(carte);

        estVisite = new HashMap<>();
        predecesseur = new HashMap<>();
        infini = 1 + 16*getCarte().getTaille()*getCarte().getTaille();
    }


    /**
     * Assesseur de infini.
     *
     *
     * @return Valeur de infini.
     */
    public int getInfini() {
        return infini;
    }

    /**
     * Cout du mouvement pour aller vers une case.
     *
     *
     * @param destination Case ou on veut aller.
     *
     * @return Cout pour se déplacer.
     */
    protected int coutMouvementVers(Case destination){
        int ret = infini;

        if(destination.getType() != TypeCase.EAU && destination.getBatiment() == null)
            ret = destination.getRessource() != null ? destination.getRessource().nombreCoupsPioche() + 1 : 1;

        return ret;
    }

    /**
     * Initialisation avant d'utiliser Dijkstra.
     *
     *
     * @param depart Case de départ du calcul.
     */
    private void initialisation(Case depart){
        for (Case v : getCarte().getCases()) {
            setDistances(v, infini);
            estVisite.put(v, false);
            predecesseur.put(v, null);
        }

        setDistances(depart, 0);
    }

    /**
     * Relachement nécessaire à Dijkstra.
     *
     *
     * @param a Une des deux cases à comparer.
     * @param b Une des deux cases à comparer.
     */
    private void relachement(Case a, Case b){
        if (getDistance(b) > getDistance(a) + coutMouvementVers(b)){
            setDistances(b, getDistance(a) + coutMouvementVers(b));
            predecesseur.put(b, a);
        }
    }

    private Case getCaseLaPlusProche(){
        int distanceMin = infini;
        Case res = null;

        for(Case C : getCarte().getCases()){
            if(!estVisite.get(C) && getDistance(C) < distanceMin){
                distanceMin = getDistance(C);
                res = C;
            }
        }

        return res;
    }


    @Override
    public void calculerDistancesDepuis(Case depart) {
        initialisation(depart);

        Case caseLaPlusProche = getCaseLaPlusProche();
        while (caseLaPlusProche != null){
            estVisite.put(caseLaPlusProche, true);

            for (Case v : caseLaPlusProche.getVoisins()) {
                relachement(caseLaPlusProche, v);
            }

            caseLaPlusProche = getCaseLaPlusProche();
        }
    }

    @Override
    public ArrayList<TypeMouvement> getChemin(Case arrivee) {
        ArrayList<TypeMouvement> res = new ArrayList<>();
        Case c = arrivee;

        while(c != null && getDistance(c) != 0){
            if(predecesseur.get(c) != null){
                res.add( ( predecesseur.get(c) ).getMouvementPourAller(c) );
                c = predecesseur.get(c);
            } else {
                c = null;
                res.clear();
            }
        }

        Collections.reverse(res);
        return res;
    }
}
