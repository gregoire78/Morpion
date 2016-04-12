package com.morpioncorp;

import java.util.Scanner;

/**
 * Created by gregoire on 12/04/2016.
 */
public class Intro {

    public void afficher(){
        Scanner sc = new Scanner(System.in);

        System.out.println("MORPION IMPOSSIBLE");
        System.out.println(
            "L’agence mission impossible recrute un nouvel espion.\n" +
            "Vous avez été sélectionné comme candidat.\n" +
            "Votre première mission, si toutefois vous l’acceptez, sera de vaincre votre concurrent.\n" +
            "Acceptez-vous la mission [Y/n] : \n" +
            "/!\\ ce message s’autodétruira dans : 5 4 3 2 1 BOOOOMMMM !!!!\n"
        );
    }
}
