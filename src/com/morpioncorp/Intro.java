package com.morpioncorp;

import java.io.IOException;
import java.util.Scanner;
import java.lang.*;
import java.util.*;

import static java.lang.System.exit;

/**
 * Created by gregoire on 12/04/2016.
 */
public class Intro{

    public void afficher(){
        char accept;
        Scanner sc = new Scanner(System.in);

        System.out.println("MORPION IMPOSSIBLE");
        System.out.print(
            "L’agence mission impossible recrute un nouvel espion.\n" +
            "Vous avez été sélectionné comme candidat.\n" +
            "Votre première mission, si toutefois vous l’acceptez, sera de vaincre votre concurrent.\n" +
            "Acceptez-vous la mission [Y/n] : "
        );
        accept = sc.next().charAt(0);
        if (Character.toLowerCase(accept) == 'y'){

            System.out.print( "/!\\ ce message s’autodétruira dans ");
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                int seconds = 6;
                int i = 0;
                @Override
                public void run() {
                    i++;
                    if(i % seconds == 0){
                        System.out.println("\nBOOOOOOOOMMMMMMMMMMM!!!!!");
                        timer.cancel();
                    }
                    else{
                        System.out.print(seconds - (i %seconds)+" ");
                    }
                }
            },0L, 1000l);
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("Vous vous êtes dégonflé :c !");
            exit(0);
        }
    }
}
