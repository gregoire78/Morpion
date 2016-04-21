package com.morpioncorp;
import javax.sound.sampled.LineUnavailableException;
import java.util.Scanner;

public class Jeux {

    private Grille g;
    private Pion p1;
    private Pion p2;
    private  boolean on;

    /**
     * constructeur du jeux
     * @param config
     */
    //CONSTRUCTEUR
    public Jeux(Config config){
        Scanner sc = new Scanner(System.in);
        int ligne, colonne;

        System.out.println("\t===Jeux du morpion===");

        ligne = config.getLigne();
        colonne = config.getColonne();

        p1 = setPionJ1(sc);
        p2 = setPionJ2(sc, p1.getCoul());

        System.out.println("LA GRILLE :");
        this.g = new Grille(ligne, colonne);
        g.afficher();
    }

    /**
     * setter le pion 1
     * @param sc
     * @return
     */
    private Pion setPionJ1(Scanner sc) {
        char couleurP1;
        System.out.println("Veuillez choisir votre nom de code candidat 1 : ");
        couleurP1 = sc.next().charAt(0); //Astuce pour lire un char, car methode de lecture de char inexistante dans la classe Scanner
        System.out.println("candidat 1 vous recevez les pions '" + couleurP1 + "'");
        Pion p1 = new Pion(couleurP1);
        return p1;
    }

    /**
     * method qui permet de set le pion du candidat 2
     * @param sc
     * @param couleurP1
     * @return Pion
     */
    private Pion setPionJ2(Scanner sc, char couleurP1) {
        char couleurP2;
        System.out.println("Veuillez choisir votre nom de code candidat 2 : ");
        couleurP2 = sc.next().charAt(0); //Astuce pour lire un char, car methode de lecture de char inexistante dans la classe Scanner
        if (couleurP2 == couleurP1){
            System.out.println("Veuillez choisir une autre nom de code candidat 2 !");
            couleurP2 = sc.next().charAt(0);
        }
        System.out.println("candidat 2 vous recevez les pions '" + couleurP2 + "'");
        Pion p2 = new Pion(couleurP2);
        return p2;
    }


    /**
     * method qui permet la gestion des tours pour les candidats
     */
    public void tour(){
        Scanner sc = new Scanner(System.in);
        this.on = true;
        while (this.on){
            actionPion(sc, p1);
            actionPion(sc, p2);
        }
    }

    /**
     * @param sc
     * @param p
     */
    private void actionPion(Scanner sc, Pion p) {
        int ligne, colonne;
        System.out.println("candidat " + p.getCoul() + " : Entrez la coordonnee de la ligne");
        ligne = sc.nextInt();
        System.out.println("candidat " + p.getCoul() + " : Entrez la coordonnee de la colonne");
        colonne = sc.nextInt();
        if(!g.deplacer(ligne, colonne, p)){
            System.out.println("Hay carramba, encore raté !!!");
            actionPion(sc, p);
        }
        isFinished(p);
    }

    /**
     * @param p
     */
    private void isFinished(Pion p) {
        g.afficher();
        //System.out.println(g.getNbEmptyC());
        if (ruleInGrille(p)){
            System.out.println("partie terminée");
            this.on = false;
            new Menu( new Config()).afficher();
        }
    }

    boolean ruleInGrille(Pion p) {
        if (g.winRules(p)) {
            try {
                SoundUtils.tone(800,500);
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
            System.out.println(p.getCoul() + " : Morpion accompli !!\nBienvenue dans L'agence Morpion Impossible Mr." + p.getCoul());
            return true;
        }
        else if (g.getNbEmptyC() == 0){
            System.out.println("Egalité . Merci de votre participation");
            return true;
        }
        return false;
    }
}