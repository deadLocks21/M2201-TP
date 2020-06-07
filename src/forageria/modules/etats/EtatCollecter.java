package forageria.modules.etats;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.ressources.TypeRessource;
import forageria.modules.ModuleDecision;

import java.util.ArrayList;

/**
 * Etat qui va collecter une ressource en particulier.
 */
public class EtatCollecter extends Etat {
    /**
     * Permet de stocker le chemin jusqu'à une ressource.
     */
    ArrayList<TypeMouvement> chemin;
    /**
     * Ressource à collecter.
     */
    TypeRessource ressource;

    /**
     * Constructeur de l'EtatCollecter.
     *
     * @param module Valeur de la variable module.
     */
    public EtatCollecter(ModuleDecision module, ArrayList<TypeMouvement> chemin, TypeRessource ressource) {
        super(module);

        this.chemin = chemin;
        this.ressource = ressource;
    }


    @Override
    public Etat transition() {
        return null;
    }

    @Override
    public void action() {

    }
}
