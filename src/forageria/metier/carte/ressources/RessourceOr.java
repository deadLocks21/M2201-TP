package forageria.metier.carte.ressources;

import forageria.metier.carte.cases.Case;

/**
 * Classe représentant un or.
 */
public class RessourceOr extends Ressource {
    /**
     * Constructeur de la classe RessourceOr.
     *
     * @param position Case ou se trouve la ressource.
     */
    public RessourceOr(Case position) {
        super(position);
    }


    @Override
    public TypeRessource getType() {
        return TypeRessource.OR;
    }

    @Override
    public int nombreCoupsPioche() {
        return 3;
    }
}
