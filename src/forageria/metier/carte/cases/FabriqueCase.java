package forageria.metier.carte.cases;

import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.ressources.FabriqueRessource;

/**
 * Classe permettant de fabriquer des cases.
 */
public class FabriqueCase {
    /**
     * Méthode permettant de retourner une case en fonction de lettre.
     *
     *
     * @param coordonnee  Coordonnées de la case à créer.
     * @param lettre    Identifiant de la ressource à créer.
     *
     * @return Case créée en fonction de la lettre.
     */
    public static Case creer(Coordonnee coordonnee, Character lettre){
        Case c = null;

        switch (lettre){
            case 'W':
                c = new CaseEau(coordonnee);
                break;
            default :
                c = new CaseHerbe(coordonnee);
                break;
        }
        c.setRessource(FabriqueRessource.creer(c,lettre));

        return c;
    }
}
