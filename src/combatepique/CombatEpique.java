/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combatepique;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author guill
 * @version 1.0
 */
public class CombatEpique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numJoueur = 1;
        Personnage joueur1 = creerJoueur(numJoueur);// création du premier joueur
        System.out.println(joueur1.toString());
        numJoueur++;
        Personnage joueur2 = creerJoueur(numJoueur);//création du second joueur
        System.out.println(joueur2.toString());
        joueur1.setAdversaire(joueur2);
        joueur2.setAdversaire(joueur1);
        joueur1.activeJoueur();//début du jeu
    }


    /**
     * Retourne un joueur en le créant grace aux caractéristiques rentrés au clavier
     * 
     * @param numJoueur
     *          numéro du joueur
     * @return Joueur créé grace au caractéristiques données au clavier
     */
    private static Personnage creerJoueur(int numJoueur) {
        Personnage p;
        int type, niveau, force, agilite, intelligence;
        System.out.println("Création du personnage du Joueur " + numJoueur);
        type = demande("Veuillez choisir la classe de votre personnage \n 1 : Guerrier \n 2 : Rôdeur \n 3 : Mage", 1, 3);
        do {
            niveau = demande("Niveau du personnage ?", 1);
            force = demande("Force du personnage ?", 0);
            agilite = demande("Agilité du personnage ?", 0);
            intelligence = demande("Intelligence du personnage ?", 0);
            if (force + agilite + intelligence != niveau) {
                System.out.println("Attention le total force + agilité + intelligence doit être égal au niveau du joueur.");
            }
        } while (force + agilite + intelligence != niveau);
        switch (type) {
            case 1:
                p = new Guerrier(numJoueur, force, agilite, intelligence);
                break;
            case 2:
                p = new Rodeur(numJoueur, force, agilite, intelligence);
                break;
            case 3:
                p = new Mage(numJoueur, force, agilite, intelligence);
                break;
            default:
                p = new Mage(numJoueur, force, agilite, intelligence);
                break;
        }
        return p;
    }


    /**
     * Effectue une demande et retourne la réponse numérique
     *
     * @param str la demande à faire
     * @param min valeur minimale du choix
     * @return le choix fait par l'utilisateur
     */
    public static int demande(String str, int min) {
        int choix;
        boolean choixCorrect;
        Scanner sc = new Scanner(System.in);
        do {
            choix = 0;
            System.out.println(str);
            try {
                choixCorrect = true;
                choix = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
                choixCorrect = false;
            }
            if (choixCorrect) {
                if (!(choix >= min)) choixCorrect = false;
            }
        } while (!choixCorrect);
        return choix;
    }


    /**
     * Effectue une demande et retourne la réponse
     *
     * @param str la demande à faire
     * @param min valeur minimale du choix
     * @param max valeur maximale du choix
     * @return le choix fait par l'utilisateur
     */
    public static int demande(String str, int min, int max) {
        int choix;
        do {
            choix = demande(str, min);
        } while (choix > max);
        return choix;
    }
    
}
