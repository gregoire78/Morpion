package com.morpioncorp;
import java.util.Scanner;

public class Jeux {

    private Grille g;
    private Pion p1;
    private Pion p2;
    private  boolean on;

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

    private Pion setPionJ1(Scanner sc) {
        char couleurP1;
        System.out.println("Veuillez choisir votre couleur joueur 1 : ");
        couleurP1 = sc.next().charAt(0); //Astuce pour lire un char, car methode de lecture de char inexistante dans la classe Scanner
        System.out.println("Joueur 1 vous recevez les pions '" + couleurP1 + "'");
        Pion p1 = new Pion(couleurP1);
        return p1;
    }

    private Pion setPionJ2(Scanner sc, char couleurP1) {
        char couleurP2;
        System.out.println("Veuillez choisir votre couleur joueur 2 : ");
        couleurP2 = sc.next().charAt(0); //Astuce pour lire un char, car methode de lecture de char inexistante dans la classe Scanner
        if (couleurP2 == couleurP1){
            System.out.println("Veuillez choisir une autre couleur !");
            setPionJ2(sc, couleurP1);
        }
        System.out.println("Joueur 2 vous recevez les pions '" + couleurP2 + "'");
        Pion p2 = new Pion(couleurP2);
        return p2;
    }


    public void tour(){
        Scanner sc = new Scanner(System.in);
        this.on = true;
        while (this.on){
            actionPion(sc, p1);
            actionPion(sc, p2);
        }
    }

    private void actionPion(Scanner sc, Pion p) {
        int ligne, colonne;
        System.out.println("Joueur " + p.getCoul() + " : Entrez la coordonnee de la ligne");
        ligne = sc.nextInt();
        System.out.println("Joueur " + p.getCoul() + " : Entrez la coordonnee de la colonne");
        colonne = sc.nextInt();
        if(!g.deplacer(ligne, colonne, p)){
            System.out.println("Hay carramba, encore raté !!!");
            actionPion(sc, p);
        }
        isFinished();
    }

    private void isFinished() {
        g.afficher();
        System.out.println(g.getNbEmptyC());
        if (g.getNbEmptyC() == 0){
            System.out.println("partie terminée");
            this.on = false;
        }
    }
}