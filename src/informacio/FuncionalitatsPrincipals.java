package informacio;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Scanner;

import HTML.InformeCapturats;
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


                        /*
                        *
                        *
                        *
                        *       Miqueeeeel!! Proposo fer lo de la majuscula com una funcio
                        *       perque s'ha de fer servir molts més cops :)
                        *
                        */
                        String nom = balls.get(i).getName();   //Obtenim el nom de la ball
                        String aux = nom.substring(0, 1).toUpperCase(); //Ens quedem amb la primera lletra i la fem majúscula
                        String ball = aux + nom.substring(1);   //Ajuntem la primera lletra majúscula amb la resta de la paraula per obtenir el nom sencer
                        System.out.println("\t- " + jugador.getPokeballs(i) + "x " + ball);
                    }
                }
                break;

            case 4:
                int nPokemon = 0;
                if (jugador.quantitatPokeballs() == 0)
                    System.out.println("Ho sentim, però no té Pokéballs disponibles, pel que no pot buscar Pokémons.");
                else {
                    while (!Missio.isTrobat()) nPokemon = Missio.trobarPokemon(pokemon, llegendaris, mitics);
                    Missio.ferMissio(jugador, balls, pokemon.get(nPokemon-1), mitics);
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
                    //Si longitud no és vàlida, mostrem error
                    if (longitud < -180 || longitud > 180) { System.out.println("Introdueixi una longitud entre -180 i 180."); }
                }

                //Obtenció gym més proper a partir de la distància manhattan
                Gym gymProper = jugador.gimnasProper(latitud, longitud, llegendaris);
                System.out.println("\nGimnàs més proper: " + gymProper.getName() + ". Comencant raid...");

                System.out.println();
                break;

            case 6:

                System.out.println("\nRecerques Especials:");
                //String info;
                for (Mythical m: mitics) {
                    if (!(m.getSr().getPercentatge() == 100 || m.getSr().getPercentatge() == 0.0)) {
                        System.out.println("\n\n\t-" + m.getSr().getName() + " (" + m.getName() + "):");
                        for (Quest q: m.getSr().getQuests()) {
                            System.out.println("\t\t* Capturar " + getPokemon(q.getTarget()).getName() + ": " +  q.getCapturated()
                                    + "/" + q.getQuantity() + " (" + q.getPercentatge() + "%)");
                        }
                    }
                }
                break;
            case 7:
                InformeCapturats.generarFitxer(jugador);
                break;
            case 8:
                break;

        }
    }

    public Pokemon getPokemon(int id) {
        Pokemon trobat = null;
        for (Pokemon p: pokemon) {
            if (p.getId().equals(id)){
                trobat = p;
            }
        }
        return trobat;
    }
}

