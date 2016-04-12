package com.morpioncorp;

/**
 * Created by gregoire on 29/03/2016.
 */
public class Pion {
    private char coul;

    Pion( char c){
        coul = c;
    }

    //ACCESSEURS
    public char getCoul(){
        return coul;
    }

    //MUTATEURS
    public void setCoul(char c){
        coul = c;
    }
}
