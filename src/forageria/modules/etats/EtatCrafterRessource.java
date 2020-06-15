package forageria.modules.etats;

import forageria.metier.carte.ressources.TypeMateriau;
import forageria.metier.carte.ressources.TypeRessource;
import forageria.modules.ModuleDecision;

import java.util.ArrayList;

import static forageria.metier.carte.ressources.TypeMateriau.BOIS;
import static forageria.metier.carte.ressources.TypeRessource.ARBRE;

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
        Etat nouvelEtat;

        // TODO Ajouter les ressources à crafter.
        switch (materiau){
            case CHARBON:
                ArrayList<TypeRessource> bois = new ArrayList<>();
                bois.add(ARBRE);

                nouvelEtat = getMemoire().getQuantiteMateriel(BOIS) < 2 ? new EtatRechercheRessource(getModule(), bois) : new EtatCrafterAuFourneau(getModule(), materiau);
                break;
            default:
                nouvelEtat = new EtatAttendre(getModule());
        }

        return nouvelEtat;
    }

    @Override
    public void action() {

    }
}
