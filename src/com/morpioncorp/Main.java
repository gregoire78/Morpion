package com.morpioncorp;

public class Main {

    public static void main(String[] args) {
        Config config = new Config();
        Intro intro= new Intro();
        Menu menu = new Menu(config);
        intro.afficher();
        menu.afficher();
    }
}
