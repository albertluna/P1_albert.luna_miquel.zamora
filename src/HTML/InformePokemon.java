package HTML;

import dades_joc.pokemons.Pokemon;

import java.io.*;
import java.net.*;

public class InformePokemon {

    private static final String BASE = "https://pokeapi.co/api/v2/";
    private static final String FOTO = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/";
    private static final String INFORME1 = "https://pokeapi.co/api/v2/pokemon-species/";
    private static final String INFORME2 = "https://pokeapi.co/api/v2/pokemon/";
    private static String flavorText = "";
    private static String weight = "";
    private static String height = "";
    private static String baseExperience = "";
    private static String nomPokemon = "";

    public static void generarInforme(Pokemon pokemon) {
        nomPokemon = pokemon.getName().toLowerCase();
        //nomPokemon = nomPokemon.toLowerCase().charAt(0) + nomPokemon.substring(1, nomPokemon.length()).toLowerCase();

        //Ens provem de connectar a l'API
        try {
            //CARREGUEM TOTA LA INFORMACIÓ DEL PRIMER INFORME DEL POKÉMON EN UNA STRING AUXILIAR
            //Primer connectem amb l'API
            URL url = new URL(INFORME1 + nomPokemon + "/");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            //Fem un GET per obtenir la informació del Pokémon
            con.setRequestMethod("GET");
            //Obtenim la resposta de la petició a l'API
            int status = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            //Variables auxiliars que ens serviran per guardar la informació del Pokémon
            String inputLine;
            StringBuffer content = new StringBuffer();
            //Guardem la informació del Pokémon a la variable "content"
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            //SEGUIT DE CÀLCULS PER TROBAR LA DESCRIPCIÓ DEL POKÉMON
            //Primer busquem la paraula clau, i ens guardem la posició de l'String on es troba
            int indexInici = content.indexOf("flavor_text_entries");
            //Busquem la descripció que està en el llenguatge "en" (anglès), i ens guardem la posició de l'String on es troba
            int indexFinal = content.indexOf(",\"language\":{\"name\":\"en\"");
            //Tallem l'String amb l'informació que ens interessa a nosaltres (en aquest cas la descripció)
            flavorText = content.substring(indexInici, indexFinal - 1);
            //Disposem de la descripció al complert, però encara hi ha caràcters extres que no desitgem, fem un bucle per acabar-ho d'arreglar
            int i = flavorText.length() - 1;
            int aux = 0;
            //Bucle per buscar la posició exacta de la descripió
            while (i >= 0 && aux == 0) {
                if (flavorText.charAt(i) == '"') {
                    //Ens guardem la posició a la que tallarem l'String
                    aux = i + 1;
                }
                i--;
            }
            //Tallem l'string amb la posició exacta perquè només ens quedi la descripció del Poémon
            flavorText = flavorText.substring(aux);

            //CARREGUEM TOTA LA INFORMACIÓ DEL SEGON INFORME DEL POKÉMON EN UNA STRING AUXILIAR
            //Primer connectem amb l'API
            url = new URL(INFORME2 + nomPokemon + "/");
            con = (HttpURLConnection) url.openConnection();
            //Fem un GET per obtenir la informació del Pokémon
            con.setRequestMethod("GET");
            //Obtenim la resposta de la petició a l'API
            status = con.getResponseCode();
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            //Variables auxiliars que ens serviran per guardar la informació del Pokémon
            content = new StringBuffer();
            //Guardem la informació del Pokémon a la variable "content"
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            //SEGUIT DE CÀLCULS PER TROBAR L'ALTURA DEL POKÉMON
            //Primer busquem la paraula clau, i ens guardem la posició de l'String on es troba
            indexInici = content.indexOf("height") + 8;
            //Tallem l'String amb l'informació que ens interessa a nosaltres (en aquest cas l'altura)
            height = content.substring(indexInici);
            //Busquem la primera ','
            for (i = 0; i < height.length(); i++) {
                if (height.charAt(i) == ',') {
                    //Ens guardem la posició a la que tallarem l'String
                    indexFinal = i;
                    //Un cop trobada la primera ',' acabem el bucle
                    break;
                }
            }
            //Tallem l'String amb l'informació que ens interessa a nosaltres (en aquest cas l'altura)
            height = height.substring(0, indexFinal);

            //SEGUIT DE CÀLCULS PER TROBAR EL PES DEL POKÉMON
            //Primer busquem la paraula clau, i ens guardem la posició de l'String on es troba
            indexInici = content.indexOf("weight") + 8;
            //Tallem l'String amb l'informació que ens interessa a nosaltres (en aquest cas el pes)
            weight = content.substring(indexInici);
            //Busquem el '}'
            for (i = 0; i < weight.length(); i++) {
                if (weight.charAt(i) == '}') {
                    //Ens guardem la posició a la que tallarem l'String
                    indexFinal = i;
                    //Un cop trobat el '}' acabem el bucle
                    break;
                }
            }
            //Tallem l'String amb l'informació que ens interessa a nosaltres (en aquest cas el pes)
            weight = weight.substring(0, indexFinal);

            //SEGUIT DE CÀLCULS PER TROBAR L'EXPERIÈNCIA BASE DEL POKÉMON
            //Primer busquem la paraula clau, i ens guardem la posició de l'String on es troba
            indexInici = content.indexOf("base_experience") + 17;
            //Tallem l'String amb l'informació que ens interessa a nosaltres (en aquest cas l'experiència base)
            baseExperience = content.substring(indexInici);
            //Busquem la primera ','
            for (i = 0; i < baseExperience.length(); i++) {
                if (baseExperience.charAt(i) == ',') {
                    //Ens guardem la posició a la que tallarem l'String
                    indexFinal = i;
                    //Un cop trobada la primera ',' acabem el bucle
                    break;
                }
            }
            //Tallem l'String amb l'informació que ens interessa a nosaltres (en aquest cas l'altura)
            baseExperience = baseExperience.substring(0, indexFinal);

        //Si no ens hem pogut connectar a l'API, donem error
        } catch (IOException e) {
            e.printStackTrace();
        }

        String contingut = "";
            try {
                FileOutputStream fos = new FileOutputStream(new File("fitxers/html/informe_pokemon.html"));
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                contingut = "<!doctype html>" +
                        "<html lang=\"es\">" +
                        "<head>" +
                        "<meta charset=\"UTF-8\">" +
                        "<title>Pokemons capturats</title>" +
                        "<meta name=\"author\" content=\"Albert Luna i Miquel Zamora - albert.luna i miquel.zamora\">" +
                        "</head>" +
                        "<body>" +
                        "<h1>" + pokemon.getName() + " (" + pokemon.getId() + ")</h1>";

                    contingut += "<img src=\"" + FOTO + pokemon.getId() + ".png\"\n" +
                            "alt=\"Foto de " + pokemon.getName() + "\" width=\"200\" height=\"200\" align: \"bottom\"/>" +
                            "<p>" + flavorText + "</p>" +
                            "<ul>" +
                                    "<li>" + height + " m.</li>" +
                                    "<li>" + weight + " kg.</li>" +
                                    "<li>" + baseExperience + " xp.</li>" +
                            "</ul>";

                contingut += "</body>" +
                        "</html>";

                oos.writeUTF(contingut);

                oos.close();
                fos.close();

            } catch (Exception e) {
                e.getStackTrace();
            }
            System.out.println("\nFitxer HTML generat.");

    }

}
