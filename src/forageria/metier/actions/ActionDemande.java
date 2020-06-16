package forageria.metier.actions;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.TypeBatiment;
import forageria.metier.carte.ressources.TypeMateriau;

import static forageria.metier.actions.TypeAction.DEMANDE;

/**
 * Permet de demander une action.
 */
public class ActionDemande extends Action {
    /**
     * Message correspondant à l'action.
     */
    private String message;


    /**
     * Constructeur de la classe.
     *
     *
     * @param message Contenu de la variable message de la classe.
     */
    public ActionDemande(String message){
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public TypeAction getType() {
        return DEMANDE;
    }

    @Override
    public TypeMouvement getDirection() {
        return null;
    }

    @Override
    public TypeMateriau getMateriau() {
        return null;
    }

    @Override
    public TypeBatiment getBatiment() {
        return null;
    }
}
