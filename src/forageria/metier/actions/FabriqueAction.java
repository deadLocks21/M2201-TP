package forageria.metier.actions;

import forageria.metier.TypeMouvement;

/**
 * Fabrique à actions.
 */
public class FabriqueAction {
    /**
     * Permet de créer le mouvement souhaité.
     *
     *
     * @param mouvement Mouvement que l'on désire.
     *
     * @return Mouvement correspondant.
     */
    public static Action creerMouvement(TypeMouvement mouvement){
        return new ActionMouvement(mouvement);
    }
}
