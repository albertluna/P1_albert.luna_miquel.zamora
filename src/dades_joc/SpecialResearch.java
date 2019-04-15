package dades_joc;

import java.util.LinkedList;

public class SpecialResearch {

    //Creació atributs
    private String name;
    private Quest[] quests;

    //Getter
    public String getName() {
        return name;
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }

    //Getter
    public LinkedList<Quest> getQuests() {
        LinkedList<Quest> quests = new LinkedList<>();
        for (int i = 0; i < this.quests.length; i++) {
            quests.add(this.quests[i]);
        }
        return quests;
    }
/*
    //Setter
    public void setQuests(LinkedList<Quest> quests) {
        this.quests = quests;
    }
*/
}
