package dades_joc.pokemons.legends;

import LlegirJSON.LegendsJSON;
import dades_joc.*;
import dades_joc.pokemons.Pokemon;

public class Legend extends Pokemon {

    private Gym gym;

    public Legend(Pokemon p, LegendsJSON l) {
        super(p.getId(), p.getName(), p.getCaptureRate());
        gym = l.getGym();
    }

    public double distanciaManhattan(double latitud, double longitud) {
        return Math.abs(latitud - gym.getLocation().getLatitude()) + Math.abs(longitud - gym.getLocation().getLongitude());
    }

    @Override
    public boolean capture(Balls ball) {
        System.out.println("HOLA    " + super.capture_rate);
        double probabilitat = (Math.pow((double)ball.getCaptureRate(), 1.5) + Math.pow((double) capture_rate, Math.PI))/4096;
        System.out.println("    Tens una probabilitat del " + probabilitat);
        return probabilitat > Math.random();
    }

    //Getter
    public Gym getGym() { return gym; }
}
