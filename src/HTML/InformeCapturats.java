package HTML;

import dades_joc.Jugador;
import dades_joc.pokemons.Pokemon;

import java.io.*;

public class InformeCapturats {

    private static final String BASE = "https://pokeapi.co/api/v2/pokemon-species/";

    public static void generarFitxer(Jugador j) {
        String contingut = "";
        try {
            FileOutputStream fos = new FileOutputStream(new File("fitxers/html/informe_capturades_6.html"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            contingut = "<!doctype html>" +
                    "<html lang=\"es\">" +
                    "<head>" +
                    "<meta charset=\"UTF-8\">" +
                    "<title>Pokemons capturats</title>" +
                    "<meta name=\"author\" content=\"Albert Luna i Miquel Zamora - albert.luna i miquel.zamorai\">" +
                    "</head>" +
                    "<body>" +
                    "<h1>Pokemons capturatss " + j.getCapturats().size() +"</h1>";
            for (Pokemon p: j.getCapturats()) {
                contingut += "<img src=\"https://i.redd.it/ap8fmgf1fzcz.jpg\"\n" +
                        "alt=\"Foto de " + p.getName() + "\" width=\"100\" height=\"100\"/>" +
                        " <span <p><b>" + p.getName() + " x1</b></p></span>";

            }

            contingut += "</body>" +
                    "</html>";

            oos.writeUTF(contingut);

            oos.close();
            fos.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
        System.out.println("Ha capturat " + j.getCapturats().size() + " Pokémons en total. Fitxer HTML creat.");
    }


}
