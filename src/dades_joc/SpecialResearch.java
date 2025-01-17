package dades_joc;

import dades_joc.pokemons.Pokemon;

import java.util.LinkedList;

public class SpecialResearch {

    //Creació atributs
    private String name;
    private Quest[] quests;
    private float percentatge;
    private boolean acabat = false;

    //Getter
    public String getName() {
        return name;
    }

    //Getter
    public boolean isAcabat() { return acabat; }

    //Getter
    public LinkedList<Quest> getQuests() {
        LinkedList<Quest> quests = new LinkedList<>();
        for (int i = 0; i < this.quests.length; i++) {
            quests.add(this.quests[i]);
        }
        return quests;
    }

    //Getter
    public float getPercentatge() {
        percentatge = 0;
        //S'actualitza el percentatge d'avanc de la special research
        for (Quest q: getQuests()) {
            percentatge += q.getPercentatge();
        }
        percentatge = percentatge/quests.length;
        return percentatge;
    }

    //Es passa un pokemon i es comprova si està en la missió i s'actualitza si hi és
    //Retorna true si s'acaba de finalitzar la missió
    public boolean afegirPokemon(Pokemon p, Jugador j) {
        for (Quest q: getQuests()) {
            if (q.getTarget().equals(p.getId())&&q.getPercentatge() != 100) {
                q.setCapturated();

                //Es finalitza la special research
                if (getPercentatge()==100) {
                    acabat = true;
                }
            }
        }
        return acabat;
    }

}
