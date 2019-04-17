import LlegirJSON.TreballDades;
import menus.MenuPrincipal;

public class Main {

    public static void main(String[] args) {

        TreballDades dades = new TreballDades();
        MenuPrincipal menu = new MenuPrincipal();

        dades.llegirJsonBalls();
        dades.llegirJsonPoke();
        dades.llegirJsonLegends();
        dades.actualitzar();

        do {
            //Mostrem el menú principal
            menu.mostrarMenu();

            //Demanem a l'usuari l'opció fins que sigui un valor vàlid
            do {
                menu.llegirOpcio();
            } while (!menu.comprovar());
            dades.mostrar(menu.getOpcio_int());
        } while (!menu.sortir());
    }
}
