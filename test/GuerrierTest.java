package xyz.fleck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuerrierTest {

    @Test
    public final void testGuerrierDescription() {
        Guerrier guerrier = new Guerrier(1, 10, 12, 8);
        assertEquals(guerrier.toString(), "Wouarggg ! Je suis le Guerrier, Joueur 1, niveau 30, je possède 150 de vitalité, 10 de force, 12 d'agilité et 8 d'intelligence.");
    }

    @Test
    public final void testGuerrierJouerCoupClassique() {
        Guerrier guerrier = new Guerrier(1, 10, 12, 8);
        Guerrier adversaire = new Guerrier(2, 10, 12, 8);
        guerrier.setAdversaire(adversaire);
        assertEquals(guerrier.jouer(1), "Joueur 1 utilise Coup d'épée et inflige 10 de dégâts");
    }

    @Test
    public final void testGuerrierJouerCoupSpecial() {
        Guerrier guerrier = new Guerrier(1, 10, 12, 8);
        Guerrier adversaire = new Guerrier(2, 10, 12, 8);
        guerrier.setAdversaire(adversaire);
        assertEquals(guerrier.jouer(2), "Joueur 1 utilise Coup de rage, inflige 20 de dégâts et perd 5 de vitalité");
    }

}

