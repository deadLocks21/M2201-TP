package forageria.modules.etats;

import forageria.modules.ModuleDecision;

/**
 * Permet de crafter à la forge.
 */
public class EtatCrafterALaForge extends Etat {
    /**
     * Constructeur d'un EtatCrafterALaForge.
     *
     * @param module Valeur de la variable module.
     */
    public EtatCrafterALaForge(ModuleDecision module) {
        super(module);
    }

    @Override
    public Etat transition() {
        return null;
    }

    @Override
    public void action() {

    }
}
