package com.morpioncorp;

public class Grille{

    private int nbEmptyC;
    private int nbLig;
    private int nbCol;
    private char [][] Grille;

    //CONSTRUCTEUR
    public Grille(int n, int p){
        nbLig = n;
        nbCol = p;
        nbEmptyC = n*p;
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

}