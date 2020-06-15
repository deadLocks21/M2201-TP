package forageria.metier.actions;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.ressources.TypeMateriau;

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

    /**
     * Permet de récupérer la direction.
     *
     *
     * @return TypeMouvement représentant la direction.
     */
    public abstract TypeMouvement getDirection() ;

    /**
     * Récupérer le matériau.
     *
     *
     * @return Matériau de la classe.
     */
    public abstract TypeMateriau getMateriau() ;
}
