package com.morpioncorp;

import java.util.Scanner;

/**
 * Created by gregoire on 29/03/2016.
 */
public class Config {
    private int colonne;
    private int ligne;

    Config(){
        this.setLigne(3);
        this.setColonne(3);
    }

    public void afficher(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\t===Config du morpion===");

        System.out.println("Veuillez entrer le nombre de lignes:");
        ligne = sc.nextInt();
        colonne = ligne;

        new Menu(this).afficher();
    }



    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }
}
