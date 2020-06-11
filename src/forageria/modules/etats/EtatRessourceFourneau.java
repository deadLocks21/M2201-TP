package forageria.modules.etats;

import forageria.metier.carte.ressources.TypeMateriau;
import forageria.metier.carte.ressources.TypeRessource;
import forageria.modules.ModuleDecision;

import java.util.ArrayList;

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
        return getMemoire().getQuantiteMateriel(TypeMateriau.PIERRE) < 10 ?
                new EtatRechercheRessource(
                        getModule(),
                        new ArrayList<>(){{
                            add(TypeRessource.ROCHER);
                        }}) :
                new EtatAttendre(getModule());
    }

    @Override
    public void action() {

    }
}
