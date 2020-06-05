package forageria.modules.etats;

import forageria.metier.actions.FabriqueAction;
import forageria.metier.actions.TypeDemande;
import forageria.modules.ModuleDecision;
import forageria.metier.actions.TypeDemande;

import static forageria.metier.actions.TypeDemande.CARTE;

/**
 * Etat qui initalise la carte.
 */
public class EtatCarte extends Etat {
    /**
     * Constructeur de l'EtatCarte.
     *
     * @param module Valeur de la variable module.
     */
    public EtatCarte(ModuleDecision module) {
        super(module);
    }


    @Override
    public Etat transition() {
        return new EtatReflexion(getModule());
    }

    @Override
    public void action() {
        getModule().ajouterActionPrioritaire(FabriqueAction.creerDemande(CARTE));
    }
}
