package esi.atl.g54027.tableview;

public class Etudiant {

    private int num;
    private String prenom;
    private String nom;

    public Etudiant(int num, String prenom, String nom) {
        this.num = num;
        this.prenom = prenom;
        this.nom = nom;
    }

    public int getNum() {
        return num;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }
}
