package LlegirJSON;

import dades_joc.Balls;
import dades_joc.pokemons.legends.Legend;
import dades_joc.pokemons.Legends;
import dades_joc.pokemons.Pokemon;

import java.util.LinkedList;

public class TransformarDadesJSON {

    public static LinkedList<Balls> balls(Balls[] balls) {
        LinkedList<Balls> pokeballs = new LinkedList();
        for (int i = 0; balls.length > i; i++) {
            pokeballs.add(balls[i]);
        }
        return pokeballs;
    }

    public static LinkedList<Pokemon> pokemons(Pokemon[] pokemon) {
        LinkedList<Pokemon> poke = new LinkedList<>();
        for (int i = 0; pokemon.length > i; i++) {
            poke.add(pokemon[i]);
        }
        return poke;
    }

    public static LinkedList<Legends> legends(Legends[] legends) {
        LinkedList<Legends> llegendaris = new LinkedList<>();
        for (int i = 0; legends.length > i; i++) {
            llegendaris.add(legends[i]);
        }

        return llegendaris;
    }
}
