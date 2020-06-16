package forageria.modules.etats;

import forageria.modules.ModuleDecision;

/**
 * Permet de savoir si le site d'une forge existe ou non.
 */
public class EtatSiteForge extends Etat {
    /**
     * Constructeur d'un état.
     *
     * @param module Valeur de la variable module.
     */
    public EtatSiteForge(ModuleDecision module) {
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
