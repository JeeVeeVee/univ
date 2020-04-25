package enums.windrichtingen;

public class Windrichting {
    private String latijnseNaam;

    public Windrichting(String ln){
        this.latijnseNaam = ln;
    }

    public String getLatijnseNaam(){
        return this.latijnseNaam;
    }
}
