package JavaFXComponenten.Tabellen.eenvoudigeTabel;

public class ZipInfo {
    private String zip;
    private String name;

    public ZipInfo(String zip, String name){
        this.zip = zip;
        this.name = name;
    }

    public String getZip(){
        return this.zip;
    }

    public String getName(){
        return this.name;
    }
}
