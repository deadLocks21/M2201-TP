package forageria.metier.carte.cases;

import forageria.metier.carte.Coordonnee;

public class CaseEau extends Case {
    /**
     * Permet d'initialiser une case d'eau.
     *
     * @param coordonnee Coordonnées de la case.
     */
    public CaseEau(Coordonnee coordonnee) {
        super(coordonnee);
    }

    @Override
    public TypeCase getType() {
        return TypeCase.EAU;
    }

    @Override
    public boolean estAccessible() {
        return false;
    }
}
