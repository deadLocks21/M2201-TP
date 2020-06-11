package forageria.metier.carte.ressources;

import forageria.metier.carte.cases.Case;

import java.util.ArrayList;

/**
 * Classe représentant un arbre.
 */
public class RessourceArbre extends Ressource {
    /**
     * Constructeur de la classe RessourceArbre.
     *
     * @param position Case ou se trouve la ressource.
     */
    public RessourceArbre(Case position) {
        super(position);
    }


    @Override
    public TypeRessource getType() {
        return TypeRessource.ARBRE;
    }

    @Override
    public int nombreCoupsPioche() {
        return 1;
    }

    @Override
    public ArrayList<TypeMateriau> getLoot() {
        ArrayList<TypeMateriau> ret = new ArrayList<>();

        ret.add(TypeMateriau.BOIS);

        return ret;
    }
}
