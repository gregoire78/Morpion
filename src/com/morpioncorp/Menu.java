package com.morpioncorp;

import java.util.Scanner;

/**
 * Created by gregoire on 29/03/2016.
 */
public class Menu {

    public Config config;
    Menu(Config config){
        this.config = config;
    }

    public void afficher(){
        // création de l'affichage du menu
        System.out.println("======== MENU DU JEU  =========");
        System.out.println("1. PLAY");
        System.out.println("2. OPTIONS");
        System.out.println("3. CREDIT");
        System.out.println("==============================");
        Scanner sc = new Scanner(System.in);
        int menuID = sc.nextInt();
        if (menuID == 1){
            Jeux jeux = new Jeux(config);
            jeux.tour();
        }
        else if(menuID == 2){
            config.afficher();
        }
        else if(menuID == 3){
            System.out.println("======== CREDIT  =========");
            System.out.println("Grégoire Joncour");
            System.out.println("Mélodie Vu");
            System.out.println("==============================");
            this.afficher();
        }
    }
}
