package informacio;

import java.util.LinkedList;
import java.util.Scanner;

import dades_joc.*;
import dades_joc.pokemons.*;
import dades_joc.pokemons.legends.Legend;
import dades_joc.pokemons.legends.Mythical;
import menus.*;

public class FuncionalitatsPrincipals {
    //Mostrem informació segons l'opció seleccionada per l'usuari del menú

    public Jugador jugador;
    public LinkedList<Balls> balls;
    public LinkedList<Legend> llegendaris;
    public LinkedList<Mythical> mitics;
    public LinkedList<Pokemon> pokemon;

    public FuncionalitatsPrincipals(LinkedList<Balls> balls, LinkedList<Pokemon> pokemons, LinkedList<Legend> llegendaris, LinkedList<Mythical> mitics) {

        this.balls = balls;
        this.pokemon = pokemons;

        this.llegendaris = llegendaris;
        this.mitics = mitics;

        this.jugador = new Jugador(this.balls);
}


    public void mostrar(int opcio_int) {

        switch (opcio_int) {
            case 1:
                jugador.actualitzarMonedes();
                break;
            case 2:
                //Constructors
                MenuComprar menu2 = new MenuComprar();

                //Mostrem les monedes que té actualment el jugador
                System.out.println("\nTeniu " + jugador.getMonedes() + " monedes.");

                //Mentres no es seleccioni l'opció de sortir mostrem el menú
                int index = menu2.mostrarMenu(balls);

                //Demanem a l'usuari l'opció fins que sigui un valor vàlid
                do {
                    menu2.llegirOpcio();
                } while (!menu2.comprovar(index));

                //Si l'usuari ha seleccionat una opció que no sigui la de sortir, segueix el programa
                if (menu2.sortir(index)) {

                    int quantitat = menu2.quantitatComprar();
                    int opcio2 = menu2.getOpcio();
                    //Si vol comprar una quantitat vàlida, actualitzem les seves dades
                    if (quantitat >= 0) {
                        jugador.actualitzarPokeballs(quantitat, balls, opcio2);
                    //Si vol comprar una quantitat no vàlida, no actualitzem les seves dades
                    } else {
                        System.out.println("\nCal introduir un nombre estrictament positiu.");
                    }
                }
                break;
            case 3:
                //Mostrem l'inventari actual del jugador

                System.out.println("\nInventari");
                for (int i = 0; i < balls.size(); i++) {
                    if (jugador.getPokeballs(i) > 0) {
                        String nom = balls.get(i).getName();   //Obtenim el nom de la ball
                        String aux = nom.substring(0, 1).toUpperCase(); //Ens quedem amb la primera lletra i la fem majúscula
                        String ball = aux + nom.substring(1);   //Ajuntem la primera lletra majúscula amb la resta de la paraula per obtenir el nom sencer
                        System.out.println("\t- " + jugador.getPokeballs(i) + "x " + ball);
                    }
                }
                break;

            case 4:

                if (jugador.quantitatPokeballs() == 0) {
                    System.out.println("Ho sentim, però no té Pokéballs disponibles, pel que no pot buscar Pokémons.");
                } else {
                    System.out.println("Quin Pokémon vol buscar?");
                    Scanner llegir = new Scanner(System.in);
                    int nPokemon = llegir.nextInt();
                    if(nPokemon > 802 || nPokemon < 1) {
                        System.out.println("Ho sentim, però aquest Pokémon no existeix (encara).");
                    } else {
                        System.out.println("Un " + pokemon.get(nPokemon-1).getName() + " salvatge aparegué!");
                        //String bola = new String("pussy");
                        Missio.ferMissio(jugador, balls, pokemon.get(nPokemon-1));

                    }
                }
                break;

            case 5:
                double latitud = -91;
                double longitud = -181;
                //Bucle demanar latitud fins que sigui vàlid
                while (latitud < -90 || latitud > 90) {
                    latitud = jugador.latitudJugador();
                    //Si latitud no vàlida, mostrem error
                    if (latitud < -90 || latitud > 90) { System.out.println("Introdueixi una latitud entre -90 i 90."); }
                }

                //Bucle demanar longitud fins que sigui vàlid
                while (longitud < -180 || longitud > 180) {
                    longitud = jugador.longitudJugador();
                    //Si longitud no vàlida, mostrem error
                    if (longitud < -180 || latitud > 180) { System.out.println("Introdueixi una latitud entre -180 i 180."); }
                }

                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //Càlcul distància manhattan

                double distManMax = 0;
                double distMan = llegendaris.getFirst().distanciaManhattan(latitud, longitud);
                System.out.println("Fins aqui hem arribat.");
                int aprop = 0;

/*
                for (Legend l : llegendaris) {
                    System.out.println("\tAnem per la " + i);
                    if(l.getKind().equals("legendary")) {
                        distMan = legends.get(i).distanciaManhattan(latitud, longitud);
                        if (distMan > distManMax) {
                            distManMax = distMan;
                            aprop = i;
                        }
                    }
                }
                System.out.println("\nGimnàs més proper: " + legends.get(aprop).getGym().getName() + ". Començant raid...");
                //Trobar el pokemon del gimnas
                int nPokemon = 0;
                for (int i = 0; i < pokemon.size(); i++) {
                    if(pokemon.get(i).getId()==legends.get(aprop).getId()){
                        nPokemon = i;
                    }
                }
                System.out.println("\nEl boss de raid " + pokemon.get(nPokemon).getName() + " us repta!");
                Missio.ferMissio(jugador, balls, pokemon, aprop);*/
                /*
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;

        */
        }

    }

}

