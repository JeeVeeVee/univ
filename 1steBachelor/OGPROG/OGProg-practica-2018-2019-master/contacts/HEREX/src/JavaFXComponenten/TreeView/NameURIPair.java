package JavaFXComponenten.TreeView;

public class NameURIPair {
    private String name;
    private String URI;

    public NameURIPair(String n, String u){
        this.name = n;
        this.URI = u;
    }

    public String toString(){
        if (name == null){
            return "(unnamed)";
        } else {
            return name;
        }
    }
}
