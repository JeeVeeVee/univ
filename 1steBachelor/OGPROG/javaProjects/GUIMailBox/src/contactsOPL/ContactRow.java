package prog2.contacts;

public class ContactRow {

    private int id;

    private ContactTypeDAO.ContactType type;

    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContactTypeDAO.ContactType getType() {
        return type;
    }

    public void setType(ContactTypeDAO.ContactType type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ContactRow(int id, ContactTypeDAO.ContactType type, String address) {
        this.id = id;
        this.type = type;
        this.address = address;
    }
}
