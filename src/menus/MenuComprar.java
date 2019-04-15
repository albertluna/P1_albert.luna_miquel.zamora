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

    public void mostrarMenu(LinkedList<Balls> balls) {
        int index = 97;

        System.out.println("\nPokéballs disponibles:");

        for (Balls b : balls) {
            System.out.println("\t" + (char)index + ") " + b.getName() + ": " + b.getPrice() + " monedes");
            index++;
        }

        System.out.println("\n\t" + (char)index + ") Sortir sense comprar\n");
    }

    public boolean sortir() {
        if (opcio2 >= 'a' && opcio2 < 'e') { return true; }
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
    public boolean comprovar() {
        if (opcio2 >= 'a' && opcio2 <= 'e') { return true; }
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
