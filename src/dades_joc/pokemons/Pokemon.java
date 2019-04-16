package dades_joc.pokemons;

import dades_joc.*;

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
        System.out.println("HOLA    " + this.capture_rate);
        double probabilitat = (((double)ball.getCaptureRate() / 256) + ((double) capture_rate / 2048));
        System.out.println("    Tens una probabilitat del " + probabilitat);
        return probabilitat > Math.random();
    }

    //Getter
    public Integer getId() {
        return id;
    }

    //Setter
    public void setId(Integer id) {
        this.id = id;
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