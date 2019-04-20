package LlegirJSON;

import dades_joc.Balls;
import dades_joc.pokemons.Legend;
import dades_joc.pokemons.Pokemon;
import dades_joc.pokemons.Mythical;

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

    public static LinkedList<Legend> legends(LinkedList<Pokemon> pokemon, LegendsJSON[] legends) {
        LinkedList<Legend> llegendaris = new LinkedList<>();
        for (int i = 0; legends.length > i; i++) {
            if (legends[i].getKind().equals("legendary")) {
                for (Pokemon p: pokemon) {
                    if (p.getId().equals(legends[i].getId())) {
                        Legend l = new Legend(p, legends[i]);
                        llegendaris.add(l);
                    }
                }
            }
        }
        return llegendaris;
    }

    public static LinkedList<Mythical> mistics(LinkedList<Pokemon> pokemon, LegendsJSON[] legends) {
        LinkedList<Mythical> mitics = new LinkedList<>();
        for (int i = 0; legends.length > i; i++) {
            if (legends[i].getKind().equals("mythical")) {
                for (Pokemon p: pokemon) {
                    if (p.getId().equals(legends[i].getId())) {
                        Mythical m = new Mythical(p, legends[i]);
                        mitics.add(m);
                    }
                }
            }
        }
        return mitics;
    }
}
