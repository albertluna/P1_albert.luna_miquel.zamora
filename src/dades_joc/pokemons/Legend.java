package dades_joc.pokemons;

import LlegirJSON.LegendsJSON;
import dades_joc.*;

import java.util.LinkedList;

public class Legend extends Pokemon {

    private Gym gym;


    public Legend(Pokemon p, LegendsJSON l) {
        super(p.getId(), p.getName(), p.getCaptureRate());
        gym = l.getGym();
    }

    public double distanciaManhattan(double latJugador, double lonJugador, double latGym, double lonGym) {
        return Math.abs(latGym - latJugador) + Math.abs(lonGym - lonJugador);
    }

    @Override
    public boolean capture(Balls ball) {
        double probabilitat = (Math.pow((double)ball.getCaptureRate(), 1.5) + Math.pow((double) super.getCaptureRate(), Math.PI))/4096;
        System.out.println("    Tens una probabilitat del " + probabilitat);
        return probabilitat > Math.random();
    }

    public static boolean isLlegendari(int nPokemon, LinkedList<Legend> llegendaris) {
        boolean trobat = false;
        for (Legend l: llegendaris) {
            if (l.getId().equals(nPokemon)) {
                trobat = true;
            }
        }
        return trobat;
    }

    //Getter
    public Gym getGym() { return gym; }
}
