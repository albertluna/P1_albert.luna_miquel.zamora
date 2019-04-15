package LlegirJSON;

import dades_joc.Gym;
import dades_joc.SpecialResearch;

public class Legends {

    //Creació atributs
    private Integer id;
    private String kind;
    private Gym gym;
    private SpecialResearch special_research;

    public double distanciaManhattan(double latitud, double longitud) {
        return Math.abs(latitud - gym.getLocation().getLatitude()) + Math.abs(longitud - gym.getLocation().getLongitude());
    }

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
    public String toString() {return "" + id + " " + kind + " " + gym.toString(); }
}
