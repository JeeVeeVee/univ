package Oefeningen.ContactsGUI.DatabankAccess;

public class Person {
    private int id;
    private String voornaam;
    private String familienaam;
    private Person deze;

    public Person(int id, String voornaam, String familienaam){
        this.id = id;
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.deze = this;
    }

    public String getVoornaam(){
        return this.voornaam;
    }

    public String getFamilienaam(){
        return this.familienaam;
    }

    public int getID(){
        return this.id;
    }

    public Person getDeze(){
        return deze;
    }
}
