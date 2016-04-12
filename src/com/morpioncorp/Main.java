package com.morpioncorp;

public class Main {

    public static void main(String[] args) {
        Config config = new Config();
        Menu menu = new Menu(config);
        menu.afficher();
    }
}
