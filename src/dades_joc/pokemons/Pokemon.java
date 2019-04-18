package dades_joc.pokemons;

import dades_joc.*;

import java.util.LinkedList;

public class Pokemon {

    //Creació atributs
    protected int id;
    protected String name;
    protected int capture_rate;

    public Pokemon(int id, String name, int capture_rate) {
        this.id = id;
        this.name = name;
        this.capture_rate = capture_rate;
    }

    public boolean capture(Balls ball) {
        double probabilitat = (((double)ball.getCaptureRate() / 256) + ((double) capture_rate / 2048));
        return probabilitat > Math.random();
    }

    //La funcio retorna si el id que es passa es d'algun pokemon de la llista de pokemons
    public static boolean isInList(LinkedList<Pokemon> poke, int id) {
        boolean trobat = false;
        for (Pokemon p: poke) {
            if (p.getId().equals(id)){
                trobat = true;
            }
        }
        return trobat;
    }

    //Getter
    public Integer getId() {
        return id;
    }

    //Getter
    public String getName() {
        return name;
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }

    //Getter
    public Integer getCaptureRate() {
        return capture_rate;
    }

    //Setter
    public void setCaptureRate(Integer captureRate) {
        this.capture_rate = captureRate;
    }

    @Override
    public String toString() {
        return "Pokemon: " + name + ": " + id + ". Captura de " + capture_rate;
    }
}