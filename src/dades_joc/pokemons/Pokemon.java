package dades_joc.pokemons;

import com.google.gson.annotations.SerializedName;
import dades_joc.*;

import java.util.LinkedList;

public class Pokemon {

    //Creació atributs
    private int id;
    private String name;
    @SerializedName("capture_rate")
    private int captureRate;

    public Pokemon(int id, String name, int captureRate) {
        this.id = id;
        this.name = name;
        this.captureRate = captureRate;
    }

    public boolean capture(Balls ball) {
        double probabilitat = (((double)ball.getCaptureRate() / 256) + ((double) captureRate / 2048));
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
        return captureRate;
    }

}