package dades_joc;

import dades_joc.pokemons.Pokemon;
import dades_joc.pokemons.Legend;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Jugador {
    //Atributs
    private int monedes;
    private Scanner scanner;
    private char confirmacio;
    private int[] pokeballs;
    private double latitud;
    private double longitud;
    private LinkedList<Pokemon> capturats;
    private ArrayList<Integer> nCapturats;

    //Constructor
    public Jugador(LinkedList<Balls> balls) {
        monedes = 1000;
        scanner = new Scanner(System.in);
        pokeballs = new int[balls.size()];

        //S'inicialitzen la quantitat de pokeballs que disposa el jugador
        for (int i = 0; i < balls.size(); i++) {
            if(i == 0) {
                pokeballs[i] = 3;
            } else {
                pokeballs[i] = 0;
            }
        }
        latitud = 0;
        longitud = 0;
        capturats = new LinkedList<>();
        nCapturats = new ArrayList<>();
    }


    //Comprovar que s'hagi introduit un valor vàlid (Y/y/N/n)
    public boolean comprovarYN() {
        if (confirmacio == 'Y' || confirmacio == 'y' || confirmacio == 'N' || confirmacio == 'n') {
            return true;
        } else {
            return false;
        }
    }

    //MENÚ OPCIÓ 1: Demanar a l'usuari quantes monedes vol comprar i, si les compra, actualitzar el número de monedes
    public void actualitzarMonedes() {
        double preu = 0;
        int monedes_temporal = -1;

        //Demanem a l'usuari quantes monedes vol comprar
        System.out.println("\nQuantes monedes vol comprar?");
        monedes_temporal = scanner.nextInt();

        //Si l'usuari introduit un número de monedes vàlid (positiu), el programa segueix
        if (monedes_temporal >= 0) {
            //Segons el número de monedes que vulgui comprar, aquestes tindran un preu o un altre
            if (monedes_temporal < 250) { preu = monedes_temporal * 0.01; }
            if (monedes_temporal >= 250 && monedes_temporal < 500) { preu = monedes_temporal * 0.009; }
            if (monedes_temporal >= 500 && monedes_temporal < 1000) { preu = monedes_temporal * 0.007; }
            if (monedes_temporal >= 1000 && monedes_temporal < 10000) { preu = monedes_temporal * 0.005; }
            if (monedes_temporal >= 10000) { preu = monedes_temporal * 0.0025; }

            //Demanem a l'usuari si vol confirmar la compra
            do {
                System.out.println("\nEl preu total es de " + (float) Math.round(preu * 100) / 100 + "€. Confirma la compra? (Y/N)");
                confirmacio = scanner.next().charAt(0);
                if (!comprovarYN()) {
                    System.out.println("Cal introduir estrictament (Y/y/N/n)");
                }
            } while (!comprovarYN());

            //Cas en què l'usuari confirma la compra: actualitzem les monedes i mostrem missatge
            if (confirmacio == 'Y' || confirmacio == 'y') {
                monedes = monedes + monedes_temporal;
                System.out.println("\nS'han afegit " + monedes_temporal + " monedes al seu compte.");
            }
            //Cas en què l'usuari cancel·la la compra: mostrem missatge
            else { System.out.println("\nCompra cancel·lada."); }
            //Si l'usuari ha introduit un número de monedes no vàlid, mostrem missatge
        } else { System.out.println("\nCal introduir un nombre estrictament positiu."); }
    }

    //Getter
    public int getMonedes () { return monedes; }

    //Mètode per actualitzar les Pokeballs que té l'usuari
    public void actualitzarPokeballs (int quantitat, LinkedList<Balls> balls, int nBola) {

        //Si té suficientes monedes, actualitzem el número de Pokeballs
        if (quantitat * balls.get(nBola).getPrice() <= monedes) {
            pokeballs[nBola] = pokeballs[nBola] + quantitat;
            monedes = monedes - (quantitat * balls.get(nBola).getPrice() );
            System.out.println("\nS'han afegit " + quantitat + " " + balls.get(nBola).getName() +" al seu compte a canvi de "
                    + (quantitat * balls.get(nBola).getPrice() ) + " monedes.");
        }
        else { System.out.print("\nHo sentim, però no disposa de suficients monedes.\n"); }
    }

    //Mètode demanar Latitud actual del jugador
    public double latitudJugador () {
        System.out.println("\nLatitud actual?");
        latitud = scanner.nextDouble(); //Llegim a quina latitud es troba el jugador
        return latitud;
    }

    //Mètode demanar Latitud actual del jugador
    public double longitudJugador () {
        System.out.println("\nLongitud actual?");
        longitud = scanner.nextDouble(); //Llegim a quina latitud es troba el jugador
        return longitud;
    }

    //Mètode calcular el gimnàs més proper al jugador a partir de la Distancia Manhattan
    public Gym gimnasProper (double latitud, double longitud, LinkedList<Legend> llegendaris) {
        double distManhattanMin = Double.MAX_VALUE;
        double aux, latGym, lonGym;
        double latJugador = latitud;
        double lonJugador = longitud;

        Gym gymProper = new Gym();

        //Anem passant per tots els llegendaris de la LinkedList
        for (Legend l : llegendaris) {
            //Obtenim la latitud del gimnàs
            latGym = l.getGym().getLocation().getLatitude();
            //Obtenim la longitud del gimnàs
            lonGym = l.getGym().getLocation().getLongitude();
            //Calculem la distància manhattan
            aux = l.distanciaManhattan(latJugador, lonJugador, latGym, lonGym);
            //Si el gimnàs actual està més aprop, actualitzem les dades
            if (aux < distManhattanMin) {
                distManhattanMin = aux;
                gymProper = l.getGym();
            }
        }
        return gymProper;
    }

    //Mètode calcular el pokemon més proper al jugador a partir de la Distancia Manhattan
    public int idProper (double latitud, double longitud, LinkedList<Legend> llegendaris) {
        double distManhattanMin = Double.MAX_VALUE;
        double aux, latGym, lonGym;
        double latJugador = latitud;
        double lonJugador = longitud;
        int id = 0;

        //Anem passant per tots els llegendaris de la LinkedList
        for (Legend l : llegendaris) {
            //Obtenim la latitud del gimnàs
            latGym = l.getGym().getLocation().getLatitude();
            //Obtenim la longitud del gimnàs
            lonGym = l.getGym().getLocation().getLongitude();
            //Calculem la distància manhattan
            aux = l.distanciaManhattan(latJugador, lonJugador, latGym, lonGym);
            //Si el gimnàs actual està més aprop, actualitzem les dades
            if (aux < distManhattanMin) {
                distManhattanMin = aux;
                id = l.getId();
            }
        }
        return id;
    }

    //Getters
    public int getPokeballs(int posicio) { return pokeballs[posicio]; }
    public int quantitatPokeballs() {
        int total = 0;
        for (int i = 0; i < pokeballs.length; i++) {
            total += pokeballs[i];
        }
        return total;
    }

    //Setter
    public void setPokeballs(int posicio) { pokeballs[posicio]--; }

    //S'afegeix un pokemon capturat a la llista de capturats
    public void afegirCaptura(Pokemon p) {
        boolean capturat = false;
        int index = 0;
        for (Pokemon c: capturats) {
            //S'indica si el pokemon que es vol introduir ja ha estat capturat
            if (c.getId().equals(p.getId())) {
                capturat = true;
                index = capturats.indexOf(c);
            }
        }

        //S'afegeix a la llista segons les circumstancies
        if (capturat) {
            nCapturats.set(index, nCapturats.get(index) + 1);
        } else {
            capturats.add(p);
            nCapturats.add(1);
        }
    }

    //Getter
    public ArrayList<Integer> getNCapturats() { return nCapturats; }

    //Getter
    public LinkedList<Pokemon> getCapturats() { return capturats; }

    //Calcula el nombre total de pokemons capturats pel jugador
    public int getTotalCapturats() {
        int n = 0;
        for (Integer i: nCapturats) {
            n += i;
        }
        return n;
    }
}