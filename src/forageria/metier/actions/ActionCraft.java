package forageria.metier.actions;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.TypeBatiment;
import forageria.metier.carte.ressources.TypeMateriau;

import static forageria.metier.actions.TypeAction.CRAFT;

/**
 * Action de crafter un objet.
 */
public class ActionCraft extends Action {
    /**
     * Direction du batiment à regarder pour crafter.
     */
    TypeMouvement typeMouvement;
    /**
     * Matériau qu'on veut craft.
     */
    TypeMateriau materiau;


    /**
     * Constructeur de la classe ActionCraft.
     *
     *
     * @param typeMouvement Sens ou se trouve le batiment.
     * @param materiau      Item que l'on veut craft.
     */
    public ActionCraft(TypeMouvement typeMouvement, TypeMateriau materiau){
        this.typeMouvement = typeMouvement;
        this.materiau = materiau;
    }


    @Override
    public String getMessage() {
        String m;

        switch (materiau) {
            case CHARBON:
                m = "COAL";
                break;
            case LINGOTFER:
                m = "IRONINGOT";
                break;
            case LINGOTOR:
                m = "GOLDINGOT";
                break;
            case PIECE:
                m = "COIN";
                break;
            default:
                m = "";
        }

        return "CRAFT|" + typeMouvement + "|" + m;
    }

    @Override
    public TypeAction getType() {
        return CRAFT;
    }

    @Override
    public TypeMouvement getDirection() {
        return typeMouvement;
    }

    @Override
    public TypeMateriau getMateriau() {
        return materiau;
    }

    @Override
    public TypeBatiment getBatiment() {
        return null;
    }
}
