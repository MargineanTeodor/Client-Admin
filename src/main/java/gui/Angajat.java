package gui;

public class Angajat {
    private String id;
    private String pass;
    private int admin;

    public Angajat(String id, String pass, int admin) {
        this.id = id;
        this.pass = pass;
        this.admin = admin;
    }

    public String getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public int getAdmin() {
        return admin;
    }
}
