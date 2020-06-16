package forageria.modules.etats;

import forageria.modules.ModuleDecision;

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
        return null;
    }

    @Override
    public void action() {

    }
}
