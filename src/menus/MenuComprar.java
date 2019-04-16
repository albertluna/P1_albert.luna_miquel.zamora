package menus;

import dades_joc.Balls;

import java.util.LinkedList;
import java.util.Scanner;

public class MenuComprar {
    private char opcio2;
    private Scanner scanner;

    public MenuComprar() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu(LinkedList<Balls> balls) {
        int index = 97;

        System.out.println("\nPokéballs disponibles:");

        for (Balls b : balls) {
            String nom = b.getName();   //Obtenim el nom de la ball
            String aux = nom.substring(0, 1).toUpperCase(); //Ens quedem amb la primera lletra i la fem majúscula
            String ball = aux + nom.substring(1);   //Ajuntem la primera lletra majúscula amb la resta de la paraula per obtenir el nom sencer
            System.out.println("\t" + (char)index + ") " + ball + ": " + b.getPrice() + " monedes");
            index++;
        }

        System.out.println("\n\t" + (char)index + ") Sortir sense comprar\n");

        return index;
    }

    public boolean sortir(int index) {
        if (opcio2 >= 'a' && opcio2 < (char)index) { return true; }
        else { return false; }
    }

    public void llegirOpcio() {
        System.out.println("Esculli una opcio:");    //Demanem opció
        opcio2 = scanner.next().charAt(0); //Llegim la variable opció
        if (opcio2 < 'a' || opcio2 > 'e') {   //Si l'usuari ha introduit un valor no vàlid
            System.out.println("\nSeleccioni una opcio valida.\n");
        }
    }

    //Comprovar que s'hagi introduit un valor vàlid
    public boolean comprovar(int index) {
        if (opcio2 >= 'a' && opcio2 <= (char)index) { return true; }
        else { return false; }
    }

    public int getOpcio() { return opcio2 - 'a'; }

    public int quantitatComprar () {
        int temporal;
        System.out.println("\nQuantes unitats en vol comprar?");
        temporal = scanner.nextInt();
        return temporal;
    }

}
