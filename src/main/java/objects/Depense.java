package objects;

import java.sql.Date;

public class Depense{
    private int idDepense;
    private int idPrevision;
    private int montant;
    private Date dateDepense;

    public Depense(int idDepense, int idPrevision, int montant, Date dateDepense) {
        this.idDepense = idDepense;
        this.idPrevision = idPrevision;
        this.montant = montant;
        this.dateDepense = dateDepense;
    }

    public int getIdDepense() {
        return idDepense;
    }

    public void setIdDepense(int idDepense) {
        this.idDepense = idDepense;
    }

    public int getIdPrevision() {
        return idPrevision;
    }

    public void setIdPrevision(int idPrevision) {
        this.idPrevision = idPrevision;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Date getDateDepense() {
        return dateDepense;
    }

    public void setDateDepense(Date dateDepense) {
        this.dateDepense = dateDepense;
    }
     
}