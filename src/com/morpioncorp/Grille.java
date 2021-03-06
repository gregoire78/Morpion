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

    /**
     * method qui permet de detecter quelle ligne est rempli par un pion
     * @param p
     * @return bool
     */
    public boolean winRules(Pion p) {
        int gligne = 0;
        int gcol = 0;
        int gdiagun = 0;
        int gdiagdeux = 0;
        int gl = Grille.length-1;
        for(int i =0; i < Grille.length; i++){
            for(int j = 0 ; j < Grille.length; j++){
                // verification pour les colonnes
                if(Grille[j][i] == p.getCoul()){
                    gcol++;
                }
                // verification pour les lignes
                if(Grille[i][j] == p.getCoul()){
                    gligne++;
                }
                // verification pour la diagonales de droite
                if (Grille[gl][j] == p.getCoul()){
                    gdiagdeux++;
                    gl--;
                }
                // verification pour la diagonale de gauche
                if(Grille[j][j] == p.getCoul()){
                    gdiagun++;
                }
                // si une ligne est pleine
                if (gcol==Grille.length || gligne==Grille.length || gdiagdeux==Grille.length || gdiagun==Grille.length ) return true;
            }
            gl = Grille.length-1;
            gdiagun = 0;
            gcol=0;
            gligne=0;
            gdiagdeux=0;
        }
        return false;
    }

}