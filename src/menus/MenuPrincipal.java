package menus;

import java.util.Scanner;

public class MenuPrincipal {
    private String opcio;
    private int opcio_int;
    private char opcio_char;
    private Scanner scanner;

    public MenuPrincipal() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n1. Afegir Monedes");
        System.out.println("2. Comprar Objectes");
        System.out.println("3. Consultar Inventari");
        System.out.println("4. Buscar Pokémon Salvatge");
        System.out.println("5. Fer Raid");
        System.out.println("6. Recerques Especials Actuals");
        System.out.println("7. Informe de Capturats");
        System.out.println("8. Informació Detallada");
        System.out.println("9. Sortir\n");
    }

    public boolean sortir() { return opcio_int == 9; }

    public void llegirOpcio() { //numberformatrixsection
        System.out.println("Seleccioni una opcio:");    //Demanem opció
        opcio = scanner.nextLine(); //Llegim la variable opció en format String
        opcio_char = opcio.charAt(0);   //Transformem el primer caràcter de l'String opció a caràcter, per fer el control d'errors
        if ((opcio_char >= '0' && opcio_char <= '9') || opcio_char == '-') {   //Si l'usuari ha introduit un enter
            opcio_int = Integer.parseInt(opcio);    //Transformem tota l'String opció a enter
            if (opcio_int < 1 || opcio_int > 9) { System.out.println("\nIntrodueixi un numero valid.\n");} //Si és un valor no vàlid, mostrar error
        }
        else {
            System.out.println("\nIntrodueixi un valor valid.\n");    //Si ens han introduit un caràcter, mostrem
        }
    }

    //Comprovar que s'hagi introduit un valor vàlid
    public boolean comprovar() {
        //Si l'usuari ens ha introduit un enter, i aquest és un enter vàlid (1-9), sortirem del bucle de demanar l'opció
        if ((opcio_char >= '0' && opcio_char <= '9') && (opcio_int >= 1 && opcio_int <= 9)) { return true; }
        //Si l'usuari ens ha introduit un caràcter no vàlid, o un enter no vàlid, seguirem en el bucle de demanar l'opció
        else { return false; }
    }

    //Getter
    public int getOpcio_int() {
        return opcio_int;
    }
}
