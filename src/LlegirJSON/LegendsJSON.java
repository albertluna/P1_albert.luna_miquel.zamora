package LlegirJSON;

import com.google.gson.annotations.SerializedName;
import dades_joc.Gym;
import dades_joc.SpecialResearch;

public class LegendsJSON {

    //Creació atributs
    private Integer id;
    private String kind;
    private Gym gym;
    @SerializedName("special_research")
    private SpecialResearch specialResearch;

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
        return specialResearch;
    }

}

