package HTML;

import dades_joc.Jugador;
import dades_joc.pokemons.Pokemon;

import java.io.*;

public class InformeCapturats {

    private static final String BASE = "https://pokeapi.co/api/v2/";
    private static final String FOTO = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/";

    public static void generarFitxer(Jugador j) {
        String contingut = "";
        try {

            //Creacio del fitxer html
            FileOutputStream fos = new FileOutputStream(new File("fitxers/html/informe_capturats.html"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            //Injeccio del contingut que volem que s'introdueixi a la capcalera
            contingut = "<!doctype html>" +
                    "<html lang=\"es\">" +
                    "<head>" +
                    "<meta charset=\"UTF-8\">" +
                    "<title>Pokemons capturats</title>" +
                    "<meta name=\"author\" content=\"Albert Luna i Miquel Zamora - albert.luna i miquel.zamora\">" +
                    "</head>" +
                    "<body>" +
                    "<h1>Pokemons capturats " + j.getTotalCapturats() +"</h1>";

            //Bucle oer anar posant tota la informacio de cada pokemon
            for (Pokemon p: j.getCapturats()) {
                contingut += "<img src=\"" + FOTO + p.getId() + ".png\"\n" +
                        "alt=\"Foto de " + p.getName() + "\" width=\"100\" height=\"100\" align: \"bottom\"/>" +
                        " <span <p><b>" + p.getName() + " </b> x" + j.getNCapturats().get(j.getCapturats().indexOf(p)) + "</p></span>";
            }

            //Tancament del contingut del fitxer html
            contingut += "</body>" +
                    "</html>";

            oos.writeUTF(contingut);

            oos.close();
            fos.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
        System.out.println("Ha capturat " + j.getTotalCapturats() + " Pokémons en total. Fitxer HTML creat.");
    }


}
