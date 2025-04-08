package objects; 

public class Etat{
    private String nom;
    private int montant;
    private int reste;

    public Etat(String nom, int montant, int reste) {
        this.nom = nom;
        this.montant = montant;
        this.reste = reste;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public int getReste() {
        return reste;
    }

    public void setReste(int reste) {
        this.reste = reste;
    }
}