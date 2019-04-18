package LlegirJSON;

//Importacions
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;

import dades_joc.*;
import dades_joc.pokemons.Pokemon;
import dades_joc.pokemons.legends.Legend;
import dades_joc.pokemons.legends.Mythical;
import informacio.FuncionalitatsPrincipals;


public class TreballDades {

    private FuncionalitatsPrincipals fp;
    private Balls[] balls;
    private Pokemon[] pokemon;
    private LegendsJSON[] legends;

    //Metode per llegir gel fitxer JSON Balls
    public void llegirJsonBalls() {
        Gson gsonBalls = new Gson();
        JsonReader reader1;

        try {
            reader1 = new JsonReader(new FileReader("fitxers/balls.json"));
            balls = gsonBalls.fromJson(reader1, Balls[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Mètode per llegir el fitxer JSON Pokemon
    public void llegirJsonPoke() {
        Gson gsonPoke = new Gson();
        JsonReader reader2;

        try {
            reader2 = new JsonReader(new FileReader("fitxers/poke.json"));
            pokemon = gsonPoke.fromJson(reader2, Pokemon[].class);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Mètode per llegir el fitxer JSON Balls
    public void llegirJsonLegends() {
        Gson gsonLegends = new Gson();
        JsonReader reader3;

        try {
            reader3 = new JsonReader(new FileReader("fitxers/legends.json"));
            legends = gsonLegends.fromJson(reader3, LegendsJSON[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void actualitzar() {

        LinkedList<Balls> pokeballs = capitaliza(TransformarDadesJSON.balls(balls));
        LinkedList<Pokemon> pokemons = capitalize(TransformarDadesJSON.pokemons(pokemon));
        LinkedList<Legend> llegendaris = TransformarDadesJSON.legends(pokemons, legends);
        LinkedList<Mythical> mitics = TransformarDadesJSON.mistics(pokemons, legends);

        fp = new FuncionalitatsPrincipals(pokeballs, pokemons, llegendaris, mitics);
    }

    public void mostrar(int opcio) {
        fp.mostrar(opcio);
    }

    public static Pokemon getPokemon(int id, LinkedList<Pokemon> pokemon) {
        Pokemon trobat = null;
        for (Pokemon p: pokemon) {
            if (p.getId().equals(id)){
                trobat = p;
            }
        }
        return trobat;
    }

    private static LinkedList<Pokemon> capitalize(LinkedList<Pokemon> poke) {
        for (Pokemon p: poke) {
            String aux = p.getName().substring(0, 1).toUpperCase();
            p.setName(aux + p.getName().substring(1));
        }
        return poke;
    }

    private static LinkedList<Balls> capitaliza(LinkedList<Balls> balls) {
        for (Balls b: balls) {
            String aux = b.getName().substring(0, 1).toUpperCase();
            b.setName(aux + b.getName().substring(1));
        }
        return balls;
    }
}

