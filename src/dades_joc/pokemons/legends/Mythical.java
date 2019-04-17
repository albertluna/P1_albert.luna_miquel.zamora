package dades_joc.pokemons.legends;

import LlegirJSON.LegendsJSON;
import dades_joc.SpecialResearch;
import dades_joc.pokemons.Pokemon;

import java.util.LinkedList;

public class Mythical extends Pokemon {

    private SpecialResearch sr;

    public Mythical(Pokemon p, LegendsJSON l) {
        super(p.getId(), p.getName(), p.getCaptureRate());
        sr = l.getSpecialResearch();
    }

    //Getter
    public SpecialResearch getSr() { return sr; }

    public static boolean isMitic(int nPokemon, LinkedList<Mythical> mitics) {
        boolean trobat = false;
        for (Mythical m: mitics) {
            if (m.getId().equals(nPokemon)) {
                trobat = true;
            }
        }
        return trobat;
    }

}
