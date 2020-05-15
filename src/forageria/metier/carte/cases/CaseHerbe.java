package forageria.metier.carte.cases;

import forageria.metier.carte.Coordonnee;

public class CaseHerbe extends Case {
    /**
     * Permet d'initialiser une case d'herbe.
     *
     * @param coordonnee Coordonnées de la case.
     */
    public CaseHerbe(Coordonnee coordonnee) {
        super(coordonnee);
    }

    @Override
    public TypeCase getType() {
        return TypeCase.HERBE;
    }

    @Override
    public boolean estAccessible() {
        return super.estVide();
    }
}
