package forageria.metier.algorithmes;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.Carte;
import forageria.metier.carte.cases.Case;

import java.util.ArrayList;
import java.util.Collections;

public class ParcoursLargeur extends AlgorithmeCalculDistance {
    /**
     * Constructur de la classe.
     *
     * @param carte Représente la carte stocké par la classe.
     */
    public ParcoursLargeur(Carte carte) {
        super(carte);
    }

    @Override
    public void calculerDistancesDepuis(Case depart) {
        // RAZ
        ArrayList<Case> aTraiter = new ArrayList<Case>();
        super.reinitialisationDistances();

        // Initialisation
        aTraiter.add(depart);
        super.setDistances(depart, 0);
        Case caseEnCours;

        // Calcul
        while (aTraiter.size() > 0){
            caseEnCours = aTraiter.get(0);
            aTraiter.remove(caseEnCours);

            for (Case v : caseEnCours.getVoisins()){
                if (getDistance(v) == null){
                    if (v.estAccessible()){
                        setDistances(v, getDistance(caseEnCours) + 1);
                        aTraiter.add(v);
                    }
                }
            }
        }
    }

    @Override
    public ArrayList<TypeMouvement> getChemin(Case arrivee) {
        // Initialisation
        ArrayList<TypeMouvement> resultat = new ArrayList<>();
        Case caseEnCours = arrivee;
        Case casePrecedente;

        // Calcul
        if(caseEnCours != null){
            while(getDistance(caseEnCours) > 0){
                ArrayList<Case> voisins = caseEnCours.getVoisins();
                casePrecedente = null;

                for(Case v : voisins){
                    if( (getDistance(v) != null) && (getDistance(v) == getDistance(caseEnCours) - 1))
                        casePrecedente = v;
                }

                resultat.add(casePrecedente.getMouvementPourAller(caseEnCours));

                caseEnCours = casePrecedente;
            }
        }

        Collections.reverse(resultat);
        return resultat;
    }
}
