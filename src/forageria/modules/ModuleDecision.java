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


        if(!super.getIA().getModuleMemoire().hasCarte())
            messageAEnvoyer = "MAP";
        else {
            messageAEnvoyer = "END";
            this.getIA().arretDiscussion();
        }

        // Vérification de l'évolution des coordonées de manière numérique.
        /*if(messageRecu.equals("OK") || messageRecu.equals("START")){
            messageAEnvoyer = "PLAYER";
        } else {
            messageAEnvoyer = "MOVE|RIGHT";
            // messageAEnvoyer = "MOVE|TOP";
        }*/


        return messageAEnvoyer;
    }
}
