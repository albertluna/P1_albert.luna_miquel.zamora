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

    //Setter
    public void setId(Integer id) {
        this.id = id;
    }

    //Getter
    public String getKind() {
        return kind;
    }

    //Setter
    public void setKind(String kind) {
        this.kind = kind;
    }

    //Getter
    public Gym getGym() {
        return gym;
    }

    //Setter
    public void setGym(Gym gym) {
        this.gym = gym;
    }

    //Getter
    public SpecialResearch getSpecialResearch() {
        return special_research;
    }

    //Setter
    public void setSpecialResearch(SpecialResearch specialResearch) {
        this.special_research = specialResearch;
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

