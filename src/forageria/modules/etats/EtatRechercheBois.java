package forageria.modules.etats;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.ressources.TypeRessource;
import forageria.modules.ModuleDecision;

import java.util.ArrayList;

/**
 * Etat qui recherche l'arbre le plus proche.
 */
public class EtatRechercheBois extends Etat {
    /**
     * Permet de stocker le chemin jusqu'à un bois.
     */
    ArrayList<TypeMouvement> chemin;
    /**
     * Ressource à collecter.
     */
    TypeRessource ressource;

    /**
     * Constructeur de l'EtatRechercheBois.
     *
     * @param module Valeur de la variable module.
     */
    public EtatRechercheBois(ModuleDecision module) {
        super(module);

        // TODO Initialiser chemin.
    }


    @Override
    public Etat transition() {
        return null;
    }

    @Override
    public void action() {

    }
}
