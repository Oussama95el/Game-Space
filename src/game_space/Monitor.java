package game_space;

public class Monitor {

    private String name;
    private int quantity;

    public Monitor(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }


    public String toString(){
        return this.name + " | " + this.quantity;
    }


}
