package M2201.TP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author Hamadi & Timothé
 * version netbeans 8
 */
public class Client {
    /**
     * Attribut permettant la discussion entre le client et le serveur
     */
    private Socket socket;
    /**
     * Attribut écoutant ce que le serveur dit
     */
    private BufferedReader fluxEntrant;
    /**
     * Attribut transmettant les messages au serveur
     */
    private PrintWriter fluxSortant;

    /**
     * Permet de créer la socket avec ip et port local
     * @throws IOException 
     */
    public void connexion() throws IOException {
        socket = new Socket("127.0.0.1",1234);
    }

    /**
     * Permet de créer le fluxEntrant et le fluxSortant
     * @throws IOException 
     */
    public void creationFlux() throws IOException {
        InputStreamReader temp;
        temp = new InputStreamReader(socket.getInputStream());
        fluxEntrant = new BufferedReader(temp);
        fluxSortant = new PrintWriter(socket.getOutputStream(),true);
    }

    /**
     * Permet de discuter avec le serveur
     * @throws IOException 
     */
    public void boucleDeDiscussion() throws IOException {
        String messageRecu = "";
        String messageAEnvoyer = "";
        int where = 1;
        Random rand = new Random();


        System.out.println("−− Debut de la transmission −−");
        do{
            //Reception du message du serveur
            messageRecu = this.fluxEntrant.readLine();
            System.out.println("< "+messageRecu);


            where = rand.nextInt(4) + 1;  // Génère un nombre aléatoire entre 1 et 4

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


            fluxSortant.println(messageAEnvoyer);
            System.out.println("> "+messageAEnvoyer);
        }while(!messageRecu.equals("END"));
        System.out.println("−− Fin de la transmission −−");
    }
}
