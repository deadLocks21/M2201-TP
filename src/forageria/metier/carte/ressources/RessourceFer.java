package forageria.metier.carte.ressources;

import forageria.metier.carte.cases.Case;

import java.util.ArrayList;

/**
 * Classe représentant un fer.
 */
public class RessourceFer extends Ressource {
    /**
     * Constructeur de la classe RessourceFer.
     *
     * @param position Case ou se trouve la ressource.
     */
    public RessourceFer(Case position) {
        super(position);
    }


    @Override
    public TypeRessource getType() {
        return TypeRessource.FER;
    }

    @Override
    public int nombreCoupsPioche() {
        return 3;
    }

    @Override
    public ArrayList<TypeMateriau> getLoot() {
        ArrayList<TypeMateriau> ret = new ArrayList<>();

        for(int i = 0; i < 2; i++)
            ret.add(TypeMateriau.FER);

        return ret;
    }
}
