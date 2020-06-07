package forageria.modules.etats;

import forageria.metier.TypeMouvement;
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
     * Constructeur de l'EtatCollecter.
     *
     * @param module Valeur de la variable module.
     */
    public EtatCollecter(ModuleDecision module) {
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
