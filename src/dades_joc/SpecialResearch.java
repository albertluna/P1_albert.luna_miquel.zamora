package dades_joc;

import dades_joc.pokemons.Pokemon;

import java.util.LinkedList;

public class SpecialResearch {

    //Creació atributs
    private String name;
    private Quest[] quests;
    private float percentatge;

    //Getter
    public String getName() {
        return name;
    }

    //Getter
    public LinkedList<Quest> getQuests() {
        LinkedList<Quest> quests = new LinkedList<>();
        for (int i = 0; i < this.quests.length; i++) {
            quests.add(this.quests[i]);
        }
        return quests;
    }

    public float getPercentatge() {
        percentatge = 0;
        for (Quest q: getQuests()) {
            percentatge += q.getPercentatge();
        }
        percentatge = percentatge/quests.length;
        return percentatge;
    }

    //Es passa un pokemon i es comprova si està en la missió i s'actualitza si hi és
    //Retorna true si s'acaba de finalitzar la missió
    public boolean afegirPokemon(Pokemon p) {
        boolean fiMissio = false;
        for (Quest q: getQuests()) {
            if (q.getTarget().equals(p.getId())&&q.getPercentatge() != 100) {
                q.setCapturated();
                if (q.getCapturated()==100) {
                    fiMissio = true;
                }
            }
        }
        return fiMissio;
    }

    @Override
    public String toString() {
        String retornar = "";
        for (int i = 0; i < quests.length; i++) {
            retornar += "\n\t " + name + " " + quests[i].toString();
        }
        return retornar;
    }
}
