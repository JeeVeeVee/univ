package JavaFXComponenten.Tabellen.editeerbareTabel;

public class Student {
    private String voornaam;
    private String achternaam;
    private int score;

    public Student(String voornaam, String achternaam, int score){
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.score = score;
    }

    public String toString(){
        return voornaam + " " + achternaam;
    }

    public String getVoornaam(){
        return voornaam;
    }

    public String getAchternaam(){
        return achternaam;
    }

    public int getScore(){
        return score;
    }
}
