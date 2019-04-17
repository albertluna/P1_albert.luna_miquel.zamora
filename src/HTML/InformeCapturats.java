package HTML;

import dades_joc.Jugador;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class InformeCapturats {

    private static final String BASE = "https://pokeapi.co/api/v2/pokemon-species/";

    public static void generarFitxer(Jugador j) {
        String contingut = "";
        try {
            FileOutputStream fos = new FileOutputStream("informe_capturades.html");
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
            for (int i = 0; i < j.getCapturats().size(); i++) {
                contingut += "img src=\"" + BASE + j.getCapturats().getFirst().getId() + "\"" +
                        "alt=\"No ho estàs fent bé\"/>";
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
