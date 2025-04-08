package objects; 

import java.sql.Date;

public class Prevision{
    private int idPrevision;
    private String nom;
    private int montant;
    private Date dateDebut;
    private Date dateFin;

    public Prevision(int idPrevision, String nom, int montant, Date dateDebut, Date dateFin) {
        this.idPrevision = idPrevision;
        this.nom = nom;
        this.montant = montant;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getIdPrevision() {
        return idPrevision;
    }

    public void setIdPrevision(int idPrevision) {
        this.idPrevision = idPrevision;
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}