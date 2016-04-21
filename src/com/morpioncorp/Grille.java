package com.morpioncorp;

import java.util.ArrayList;

public class Grille{

    private int nbEmptyC;
    private int nbLig;
    private int nbCol;
    private char [][] Grille;

    //CONSTRUCTEUR
    public Grille(int n, int p){
        nbLig = n;
        nbCol = n;
        nbEmptyC = n*n;
        Grille = new char[nbLig][nbCol];

        for(int i=0;i<nbLig;i++){
            for(int j=0;j<nbCol;j++){
                Grille[i][j] = ' '; //on remplit la grille de x
            }
        }
    }

    //ACCESSEUR
    public int getNbEmptyC(){
        return nbEmptyC;
    }

    //METHODES
    public void afficher(){
        System.out.println();
        for(int i = 0 ; i <= nbCol; i++)
            System.out.print(i + " | ");
        System.out.print("\n");
        for(int i=0;i<nbLig;i++){
            System.out.print(i+1);
            for(int j=0;j<nbCol;j++){
                System.out.print(" | " + Grille[i][j]);
            }
            System.out.println(" | ");
        }
        System.out.println();
    }

    public boolean deplacer(int l, int c, Pion p){
        if (l > nbLig || c > nbCol){
            System.out.println("En dehors de la grille");
            return false;
        } else {
            l = l - 1; //On decremente  l & c (ligne et colonne) a cause du debut d'indicage du tableau a 0
            c = c - 1;
            if(Grille[l][c] == ' '){
                Grille[l][c] = p.getCoul();
                nbEmptyC = nbEmptyC - 1;
                return true;
            }
            else{
                System.out.println("Erreur, il y a deja un pion sur cette case !");
                return false;
            }
        }
    }

    boolean ruleInGrille(int l, int c, Pion p) {

        // Vérifie la ligne 1 - éléments 0, 1 et 2 du tableau
        if (winRules(p)) {
            System.out.println(p.getCoul() + " Gagne !!");
            return true;
        }else {
            return false;
        }
//        if (
//            Grille[0][0] == p.getCoul() && Grille[1][1] == p.getCoul() && Grille[2][2] == p.getCoul() || // diagonales
//            Grille[0][2] == p.getCoul() && Grille[1][1] == p.getCoul() && Grille[2][0] == p.getCoul())
//        {
//            System.out.println(p.getCoul() + " Gagne !!");
//            return true;
//        } else {
//            return false;
//        }
    }

    private boolean winRules(Pion p) {
        int gligne = 0;
        int gcol = 0;
        for(int i =0; i < Grille.length; i++){
            for(int j = 0 ; j < Grille.length; j++){
                if(Grille[j][i] == p.getCoul()){
                    gcol++;
                }
                if(Grille[i][j] == p.getCoul()){
                    gligne++;
                }
                if (gcol==Grille.length || gligne==Grille.length){
                    return true;
                }
            }
        }
        return false;
    }

}