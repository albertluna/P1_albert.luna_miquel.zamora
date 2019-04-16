package dades_joc.pokemons.legends;

import LlegirJSON.LegendsJSON;
import dades_joc.SpecialResearch;
import dades_joc.pokemons.Pokemon;

public class Mythical extends Pokemon {

    private SpecialResearch sr;

    public Mythical(Pokemon p, LegendsJSON l) {
        super(p.getId(), p.getName(), p.getCaptureRate());
        sr = l.getSpecialResearch();
    }

}
