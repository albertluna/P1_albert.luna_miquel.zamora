package informacio;

import java.util.LinkedList;
import java.util.Scanner;
import dades_joc.*;
import dades_joc.pokemons.Pokemon;

public class Missio {

    public static void ferMissio(Jugador jugador, LinkedList<Balls> balls, Pokemon pokemon) {
        for (int i = 5; i > 0; i--) {
            System.out.println("Queden " + jugador.quantitatPokeballs() + " Pokéballs i " + i +
                    "/5 intents. Quin tipus de Pokéball vol fer servir?");
            Scanner llegire = new Scanner(System.in);
            String bola = llegire.nextLine();
            boolean bolaCorrecta = false;
            int bolaGastada = 0;

            for (int k = 0; k < balls.size(); k++) {
                if(bola.equals(balls.get(k).getName())&&jugador.quantitatPokeballs()!= 0) {
                    bolaCorrecta = true;
                    jugador.setPokeballs(k);
                    bolaGastada = k;
                    k = 4;
                }
            }
            //Continua la captura si el jugador ha introduit una bola que existeix i en disposa
            if (bolaCorrecta) {

                //calcul per saber si ha capturat el pokemon
                if(pokemon.capture(balls.get(bolaGastada))) {
                    System.out.println("El " + pokemon.getName() + " ha estat capturat!");
                } else {
                    System.out.println("La " + balls.get(bolaGastada).getName() + " ha fallat!");
                }
                jugador.setPokeballs(bolaGastada);
                //Controla si el jugador ha introduit una bola que no existeix en el sistema
            } else{
                System.out.println("Aquest tipus no existeix. Quin tipus de Pokéball vol fer servir?");
                i++;
            }
        }
    }
}