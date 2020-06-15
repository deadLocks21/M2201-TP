package forageria.modules.etats;

import forageria.metier.carte.ressources.TypeMateriau;
import forageria.modules.ModuleDecision;

/**
 * Etat permettant de crafter dans un fourneau.
 */
public class EtatCrafterAuFourneau extends Etat {
    /**
     * Matériau que l'on veut crafter.
     */
    TypeMateriau materiau;

    /**
     * Constructeur d'un EtatCrafterAuFourneau.
     *
     * @param module Valeur de la variable module.
     */
    public EtatCrafterAuFourneau(ModuleDecision module, TypeMateriau materiau) {
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
