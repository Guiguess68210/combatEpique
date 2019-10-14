package combatepique;

/**
 * Classe des joueurs de type Guerrier
 *
 * @author guill
 * @version 1.0
 */
public class Guerrier extends Personnage {

    /**
     * Constructeur du joueur Guerrier
     *
     * @param numJoueur
     *          numéro du joueur
     * @param force
     *          force du joueur
     * @param agilite
     *          agilité du joueur
     * @param intelligence
     *          intelligence du joueur
     */
    protected Guerrier(int numJoueur, int force, int agilite, int intelligence) {
        super(numJoueur, force, agilite, intelligence);
        type = "Guerrier";
        cri = "Wouarggg";
    }

    /**
     * En fonction du choix, effectue les actions propres à la classe du joueur Guerrier
     * Coup d'épée ou Coup de rage
     *
     * @param choix
     *      choix de l'action
     * @see Mage#jouer(int)
     * @see Joueur#jouer(int)
     * @see Rodeur#jouer(int)
     * @return phrase de l'action
     */
    @Override
    protected String jouer(int choix) {
        String phrase = "";
        switch (choix) {
            case 1:
                adversaire.enleverVie(force);
                phrase = phrase + nom + " utilise Coup d'épée et inflige " + force + " de dégâts";
                break;
            case 2:
                adversaire.enleverVie((force * 2));
                vie = vie - force / 2;
                phrase = phrase + nom + " utilise Coup de rage, inflige " + (force * 2) + " de dégâts et perd " + (force / 2) + " de vitalité";
                break;
            default:
                break;
        }
        if (vie > 0) {
            return phrase;
        } else {
            return "Le " + nom + " n'a plus de vie, il a perdu !";
        }

    }
}
