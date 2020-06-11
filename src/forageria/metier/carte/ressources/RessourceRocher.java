package forageria.metier.carte.ressources;

import forageria.metier.carte.cases.Case;

import java.util.ArrayList;

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

    @Override
    public ArrayList<TypeMateriau> getLoot() {
        ArrayList<TypeMateriau> ret = new ArrayList<>();

        ret.add(TypeMateriau.PIERRE);

        return ret;
    }
}
