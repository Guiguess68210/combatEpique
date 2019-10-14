package combatepique;

/**
 * Classe des joueurs de type Rôdeur
 *
 * @author guill
 * @version 1.0
 */
public class Rodeur extends Personnage {

    /**
     * Constructeur du joueur Rôdeur
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
    public Rodeur(int numJoueur, int force, int agilite, int intelligence) {
        super(numJoueur, force, agilite, intelligence);
        type = "Rôdeur";
        cri = "Chuuut";
    }

    /**
     * En fonction du choix, effectue les actions propres à la classe du joueur Rôdeur
     * Tir à l'Arc ou Concentration
     *
     * @param choix
     *      choix de l'action
     * @see Mage#jouer(int)
     * @see Joueur#jouer(int)
     * @see Guerrier#jouer(int)
     * @return phrase de l'action
     */
    @Override
    protected String jouer(int choix) {
        String phrase = "";
        switch (choix) {
            case 1:
                adversaire.enleverVie(agilite);
                phrase = phrase + nom + " utilise Tir à l'Arc et inflige " + agilite + " de dégâts";
                break;
            case 2:
                agilite = agilite + (niveau / 2);
                phrase = phrase + nom + " utilise Concentration et gagne " + (niveau / 2) + " d'agilité";

                break;
            default:
                break;
        }
        return phrase;
    }
}
