package forageria.modules.etats;

import forageria.metier.actions.FabriqueAction;
import forageria.metier.actions.TypeDemande;
import forageria.modules.ModuleDecision;

/**
 * Etat lorsque notre automate s'initialise, il récupère le joueur.
 */
public class EtatInitialisation extends Etat {
    /**
     * Constructeur de l'état initialisation.
     *
     * @param module Valeur de la variable module.
     */
    public EtatInitialisation(ModuleDecision module) {
        super(module);
    }


    @Override
    public Etat transition() {
        return new EtatReflexion(getModule());
    }

    @Override
    public void action() {
        getModule().ajouterAction(FabriqueAction.creerDemande(TypeDemande.JOUEUR));
    }
}
