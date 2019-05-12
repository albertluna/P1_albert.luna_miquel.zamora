package dades_joc;

import com.google.gson.annotations.SerializedName;

public class Balls {

    //Creació atributs
    private String name;
    @SerializedName("capture_rate")
    private Integer captureRate;
    private Integer price;

    //Getter
    public String getName() {
        return name;
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }

    //Getter
    public Integer getCaptureRate() {
        return captureRate;
    }

    //Getter
    public Integer getPrice() {
        return price;
    }
}