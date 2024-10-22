package informacio;

import java.util.LinkedList;
import java.util.Scanner;
import dades_joc.*;
import dades_joc.pokemons.Legend;
import dades_joc.pokemons.Mythical;
import dades_joc.pokemons.Pokemon;

public class Missio {

    //Funció per determinar quin pokemon es vol buscar en la missio
    public static int trobarPokemon(LinkedList<Pokemon> poke, LinkedList<Legend> llegendaris, LinkedList<Mythical> mitics) {
        boolean trobat = false;
        int nPokemon = 0;

        while (!trobat) {
            System.out.println("\nQuin Pokémon vol buscar?");

            //Es llegeix el id del pokemon que es vol buscar
            Scanner llegir = new Scanner(System.in);
            nPokemon = llegir.nextInt();

            //Es determina si el pokemon existeix en el sistema
            if (!Pokemon.isInList(poke, nPokemon)) {
                System.out.println("\nHo sentim, però aquest Pokémon no existeix (encara).");
            }
            else {
                //Es mira si és un pokemon salvatge
                if (Mythical.isMitic(nPokemon, mitics) || Legend.isLlegendari(nPokemon, llegendaris)) {
                    System.out.println("\nHo sentim, però aquest Pokémon és mític i no apareix salvatge");
                } else {
                    trobat = true;
                }
            }
        }
        return nPokemon;
    }

    //Funció per fer l'acció de capturar un pokemon
    public static void ferMissio(Jugador jugador, LinkedList<Balls> balls, Pokemon poke, LinkedList<Mythical> mitics) {

        System.out.println("\nUn " + poke.getName() + " salvatge aparegué!");
        int i;

        for (i=5; i > 0; i--) {

            if (jugador.quantitatPokeballs() <= 0) {

                System.out.println("\nNo queden Pokeballs...");
                i = 0;

            } else {
                System.out.println("\nQueden " + jugador.quantitatPokeballs() + " Pokéballs i " + i +
                        "/5 intents. Quin tipus de Pokéball vol fer servir?");

                //Funció que extreu la bola que el jugador utilitzarà per fer la captura
                Balls bolaGastada = escollirPokeball(balls, jugador);

                //Càlcul per saber si ha capturat el pokemon
                if (poke.capture(bolaGastada)) {
                    System.out.println("\nEl " + poke.getName() + " ha estat capturat!");
                    i = 0;
                    actualitzarRecercaEspecial(jugador, poke, mitics);
                } else {
                    System.out.println("\nLa " + bolaGastada.getName() + " ha fallat!");
                }
            }
        }

        //S'indica que la missió ha estat fallida amb un missatge
        if (i == 0) {
            System.out.println("\nEl " + poke.getName() + " ha escapat...");
        }
    }

    //Funció perquè el jugador esculli una pokeball
    private static Balls escollirPokeball(LinkedList<Balls> balls, Jugador jugador) {

        boolean bolaCorrecta = false;
        Balls bolaGastada = new Balls();

        //Bucle que no es surt fins que el jugador esculli una pokeball que tingui
        while (!bolaCorrecta) {

            //Es llegeix el nom de la pokeball
            Scanner llegire = new Scanner(System.in);
            String bola = llegire.nextLine();

            //Es comprova si el jugador te la pokeball
            for (int k = 0; k < balls.size(); k++) {
                //El nom es correcte
                if (bola.equals(balls.get(k).getName())) {
                    //En té
                    if (jugador.getPokeballs(k) != 0) {
                        bolaCorrecta = true;
                        jugador.setPokeballs(k);
                        bolaGastada = balls.get(k);
                        k = balls.size();
                    } else {
                        //No en té cap
                        System.out.println("\nNo li queden pokeballs del tipus " + balls.get(k).getName() +
                                ". Quin tipus de Pokéball vol fer servir?");
                        k = balls.size();
                    }
                } else {
                    //Introdueix un nom d'una pokeball que no existeix
                    if (k == balls.size()-1 && !bolaCorrecta) {
                        System.out.println("\nAquest tipus no existeix. Quin tipus de " +
                                "Pokéball vol fer servir?");
                    }
                }
            }
        }
        return bolaGastada;
    }

    private static void actualitzarRecercaEspecial(Jugador j, Pokemon poke, LinkedList<Mythical> mitics) {
        j.afegirCaptura(poke);
        for (Mythical m: mitics) {
            if (!m.getSr().isAcabat()) {

                //Aquesta funcio determinarà si s'acaba de finalitzar una SpecialResearch
                //i afegirà el pokémon mític que es troba
                boolean fiMissio = m.getSr().afegirPokemon(poke, j);
                if (fiMissio) {
                    System.out.println("\nMissió de captura completada!");
                    System.out.println("\nRecerca Especial completada: Se t'apareix el mític " +m.getName() + "!");
                    j.afegirCaptura(m);
                }
            }
        }
    }
}