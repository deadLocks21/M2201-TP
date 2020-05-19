package forageria.metier.actions;

/**
 * Permet de demander une action.
 */
public class ActionDemande extends Action {
    /**
     * Message correspondant à l'action.
     */
    String message;


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
}
