package LlegirJSON;

import dades_joc.Gym;
import dades_joc.SpecialResearch;

public class LegendsJSON {

    //Creació atributs
    private Integer id;
    private String kind;
    private Gym gym;
    private SpecialResearch special_research;

    //Getter
    public Integer getId() {
        return id;
    }

    //Getter
    public String getKind() {
        return kind;
    }

    //Getter
    public Gym getGym() {
        return gym;
    }

    //Getter
    public SpecialResearch getSpecialResearch() {
        return special_research;
    }

    @Override
    public String toString() {
        String info = new String();
        if (kind.equals("mythical")) {
            info = "" + id + " " + kind + " " + special_research.toString();
        } else {
            if (kind.equals("legendary")) {
                info = "" + id + " " + kind + " " + gym.toString();
            }
        }
        return info;
    }
}

