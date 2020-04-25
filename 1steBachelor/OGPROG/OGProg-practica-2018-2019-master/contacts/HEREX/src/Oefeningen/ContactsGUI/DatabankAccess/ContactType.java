package Oefeningen.ContactsGUI.DatabankAccess;

import java.util.Map;

public class ContactType {
    private final char type;
    private final String name;

    private static final Map<String, String> converter = Map.of(
            "E", "E-mail",
            "F", "Fax",
            "M", "Mobiele Telefoon",
            "T", "Vaste Telefoon"
    );

    public ContactType(char type, String name) {
        this.type = type;
        this.name = name;
    }


}
