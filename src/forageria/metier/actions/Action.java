package forageria.metier.actions;

/**
 * Classe abstraite d'une action.
 */
public abstract class Action {
    /**
     * Permet de récupérer un message.
     *
     *
     * @return Message sous forme de chaine de caractères.
     */
    public abstract String getMessage();

    /**
     * Permet de récupérer le type de l'action d'une classe fille.
     *
     *
     * @return TypeAction correspondant.
     */
    public abstract TypeAction getType();
}
