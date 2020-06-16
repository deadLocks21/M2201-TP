package forageria.modules.etats;

import forageria.metier.carte.ressources.TypeMateriau;
import forageria.metier.carte.ressources.TypeRessource;
import forageria.modules.ModuleDecision;

import java.util.ArrayList;

import static forageria.metier.carte.ressources.TypeMateriau.LINGOTFER;
import static forageria.metier.carte.ressources.TypeMateriau.PIERRE;
import static forageria.metier.carte.ressources.TypeRessource.ROCHER;

/**
 * Permet de rechercher les ressources pour crafter une forge.
 */
public class EtatRessourceForge extends Etat {
    /**
     * Constructeur d'un EtatRessourceForge.
     *
     * @param module Valeur de la variable module.
     */
    public EtatRessourceForge(ModuleDecision module) {
        super(module);
    }

    @Override
    public Etat transition() {
        Etat nouvelEtat = new EtatSiteForge(getModule());

        ArrayList<TypeRessource> ressources =  new ArrayList<>();
        ressources.add(ROCHER);

        if (getMemoire().getQuantiteMateriel(PIERRE) < 4)
            nouvelEtat = new EtatRechercheRessource(getModule(), ressources);

        else if (getMemoire().getQuantiteMateriel(LINGOTFER) < 4)
            nouvelEtat = new EtatCrafterRessource(getModule(), LINGOTFER);

        return nouvelEtat;
    }

    @Override
    public void action() {

    }
}
