package forageria.metier.carte.ressources;

import forageria.metier.carte.cases.Case;

/**
 * Classe permettant de fabriquer des ressources.
 */
public class FabriqueRessource {
    /**
     * Méthode permettant de retourner une ressource en fonction de lettre.
     *
     *
     * @param position  Position de la ressource à créer.
     * @param lettre    Identifiant de la ressource à créer.
     *
     * @return Ressource créée en fonction de la lettre.
     */
    public static Ressource creer(Case position, Character lettre){
        Ressource res = null;

        switch (lettre){
            case 'T':
                res = new RessourceArbre(position);
                break;
            case 'R':
                res = new RessourceRocher(position);
                break;
            case 'I':
                res = new RessourceFer(position);
                break;
            case 'G':
                res = new RessourceOr(position);
                break;
        }

        return res;
    }
}
