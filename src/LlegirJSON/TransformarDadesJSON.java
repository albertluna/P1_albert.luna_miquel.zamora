package LlegirJSON;

import dades_joc.Balls;
import dades_joc.pokemons.Legend;
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

    public static LinkedList<Legend> legends(LinkedList<Pokemon> pokemons, Legends[] legends) {
        LinkedList<Legend> llegendaris = new LinkedList<>();
        for (Pokemon p : pokemons) {
            for (int j = 0; j < legends.length; j++) {
                if ((legends[j].getId() == p.getId())&&(legends[j].getKind().equals("legendary"))) {
                    Legend l = new Legend(p, legends[j]);
                    llegendaris.add(l);
                }
            }
        }
        return llegendaris;
    }
}
