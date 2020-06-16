package forageria.modules.etats;

import forageria.modules.ModuleDecision;

/**
 * Permet de construire une forge.
 */
public class EtatConstruireForge extends Etat {
    /**
     * Constructeur d'un EtatConstruireForge.
     *
     * @param module Valeur de la variable module.
     */
    public EtatConstruireForge(ModuleDecision module) {
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
