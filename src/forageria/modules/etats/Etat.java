package forageria.modules.etats;

import forageria.modules.ModuleDecision;
import forageria.modules.ModuleMemoire;

/**
 * Représente un état de notre automate.
 */
public abstract class Etat {
    /**
     * Stocke le module de décision.
     */
    private ModuleDecision module;
    /**
     * Stocke le module mémoire.
     */
    private ModuleMemoire memoire;


    /**
     * Constructeur d'un état.
     *
     *
     * @param module Valeur de la variable module.
     */
    public Etat(ModuleDecision module){
        this.module = module;
        this.memoire = module.getIA().getModuleMemoire();
    }


    /**
     * Assesseur de la variable module.
     *
     *
     * @return Variable Module.
     */
    public ModuleDecision getModule() {
        return module;
    }

    /**
     * Assesseur de la variable Memoire.
     *
     *
     * @return Variable Memoire.
     */
    public ModuleMemoire getMemoire() {
        return memoire;
    }


    /**
     * Code une transition vers un autre Etat.
     *
     *
     * @return  Nouvel Etat.
     */
    public abstract Etat transition();

    /**
     * Action que doit effectuer notre Etat.
     */
    public abstract void action();
}
