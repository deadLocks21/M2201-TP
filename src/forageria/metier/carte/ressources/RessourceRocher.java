package forageria.metier.carte.ressources;

import forageria.metier.carte.cases.Case;

/**
 * Classe représentant un rocher.
 */
public class RessourceRocher extends Ressource {
    /**
     * Constructeur de la classe RessourceRocher.
     *
     * @param position Case ou se trouve la ressource.
     */
    public RessourceRocher(Case position) {
        super(position);
    }


    @Override
    public TypeRessource getType() {
        return TypeRessource.ROCHER;
    }

    @Override
    public int nombreCoupsPioche() {
        return 2;
    }
}
