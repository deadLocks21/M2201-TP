package forageria.modules;

import forageria.IA;

import java.util.Random;

/**
 * Module en charge de la prise de décision
 * @author Matthieu
 */
public class ModuleDecision extends Module {

    public ModuleDecision(IA ia) {
        super(ia);
    }

    /**
     * Méthode principale de prise de décision
     * @param messageRecu dernier message reçu du serveur
     * @return Le prochain message à envoyer
     */
    public String determinerNouvelleAction(String messageRecu) {
        String messageAEnvoyer = "END";

        Random rand = new Random();
        int where = rand.nextInt(4) + 1;  // Génère un nombre aléatoire entre 1 et 4

        // En fonction de where, change la direction.
        switch (where){
            case 1:
                messageAEnvoyer = "MOVE|TOP";
                break;
            case 2:
                messageAEnvoyer = "MOVE|LEFT";
                break;
            case 3:
                messageAEnvoyer = "MOVE|BOTTOM";
                break;
            case 4:
                messageAEnvoyer = "MOVE|RIGHT";
                break;
        }

        return messageAEnvoyer;
    }
}
