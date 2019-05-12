package dades_joc;

public class Quest {

    //Creació atributs
    private Integer target;
    private Integer quantity;
    private int capturated = 0;

    public float getPercentatge() { return ((float)capturated/(float)quantity)*100;}

    //Getter
    public Integer getTarget() {
        return target;
    }

    //Getter
    public Integer getQuantity() {
        return quantity;
    }

    //Getter
    public int getCapturated() { return capturated; }

    //Setter
    public void setCapturated() { this.capturated ++; }
}
