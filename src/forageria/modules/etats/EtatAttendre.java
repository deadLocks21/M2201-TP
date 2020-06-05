package forageria.modules.etats;

import forageria.metier.actions.FabriqueAction;
import forageria.metier.actions.TypeDemande;
import forageria.modules.ModuleDecision;

import static forageria.metier.actions.TypeDemande.ATTENDRE;

/**
 * Etat qui demande une attente.
 */
public class EtatAttendre extends Etat {
    /**
     * Constructeur de l'EtatAttendre.
     *
     * @param module Valeur de la variable module.
     */
    public EtatAttendre(ModuleDecision module) {
        super(module);
    }


    @Override
    public Etat transition() {
        return new EtatReflexion(getModule());
    }

    @Override
    public void action() {
        getModule().ajouterAction(FabriqueAction.creerDemande(ATTENDRE));
    }
}
