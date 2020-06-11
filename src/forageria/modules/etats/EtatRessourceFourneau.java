package forageria.modules.etats;

import forageria.modules.ModuleDecision;

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
        return null;
    }

    @Override
    public void action() {

    }
}
