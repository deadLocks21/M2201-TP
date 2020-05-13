package forageria.metier.carte;

import forageria.metier.carte.cases.Case;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe en charge de stocker la carte.
 */
public class Carte {
    /**
     * Stocke la taille de la carte.
     */
    private int taille;
    /**
     * Variable permettant de stocker les cases de notre jeu.
     */
    public Map<Coordonnee,Case> cases;


    /**
     * Constructeur de la classe Carte.
     *
     *
     * @param messageRecu Message recu par l'IA.
     */
    public Carte(String messageRecu){
        cases = new HashMap<>();
    }


    /**
     * Assesseur de la variable taille.
     *
     *
     * @return Taille de la carte.
     */
    public int getTaille() {
        return taille;
    }
}
