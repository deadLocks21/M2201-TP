package forageria.modules.etats;

import forageria.metier.carte.ressources.TypeMateriau;
import forageria.metier.carte.ressources.TypeRessource;
import forageria.modules.ModuleDecision;

import java.util.ArrayList;

import static forageria.metier.carte.ressources.TypeMateriau.LINGOTFER;
import static forageria.metier.carte.ressources.TypeMateriau.PIERRE;
import static forageria.metier.carte.ressources.TypeRessource.ROCHER;

/**
 * Etat cherchant les ressources pour construire un fourneau.
 */
public class EtatRessourceFourneau extends Etat {
    /**
     * Constructeur d'un EtatRessourceFourneau.
     *
     * @param module Valeur de la variable module.
     */
    public EtatRessourceFourneau(ModuleDecision module) {
        super(module);
    }


    @Override
    public Etat transition() {
        Etat nouvelEtat = new EtatSiteFourneau(getModule());

        ArrayList<TypeRessource> ressources =  new ArrayList<>();
        ressources.add(ROCHER);

        if (getMemoire().getQuantiteMateriel(PIERRE) < 10)
            nouvelEtat = new EtatRechercheRessource(getModule(), ressources);

        return nouvelEtat;
    }

    @Override
    public void action() {

    }
}
