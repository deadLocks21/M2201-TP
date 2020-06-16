package forageria.modules.etats;

import forageria.modules.ModuleDecision;

/**
 * Cherche le site idéal pour une forge.
 */
public class EtatTrouverSiteForge extends Etat {
    /**
     * Constructeur d'un EtatTrouverSiteForge.
     *
     * @param module Valeur de la variable module.
     */
    public EtatTrouverSiteForge(ModuleDecision module) {
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
