package forageria.modules.etats;

import forageria.metier.carte.ressources.TypeMateriau;
import forageria.modules.ModuleDecision;

/**
 * Etat permettant de crafter des ressources.
 */
public class EtatCrafterRessource extends Etat {
    /**
     * Matériau que l'on veut crafter.
     */
    TypeMateriau materiau;

    /**
     * Constructeur d'un EtatCrafterRessource.
     *
     * @param module Valeur de la variable module.
     */
    public EtatCrafterRessource(ModuleDecision module, TypeMateriau materiau) {
        super(module);

        this.materiau = materiau;
    }


    @Override
    public Etat transition() {
        return null;
    }

    @Override
    public void action() {

    }
}
