package DAOobj;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import objects.Prevision;

public class DAOprevision {

    private static final String URL = "jdbc:mysql://localhost:3306/db_s2_ETU003303";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public boolean save(String nom, int montant, Date dateDebut, Date dateFin) throws SQLException {
        String sql = "INSERT INTO Prevision(nom, montant, dateDebut, dateFin) VALUES(?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nom);
            stmt.setInt(2, montant);
            stmt.setDate(3, dateDebut);
            stmt.setDate(4, dateFin);
            int rowSaved = stmt.executeUpdate();
            return rowSaved > 0;
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

    public List<Prevision> getAll() throws SQLException {
        List<Prevision> prevs = new ArrayList<>();
        String sql = "SELECT * FROM Prevision";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("idPrevision");
                String nom = rs.getString("nom");
                int montant = rs.getInt("montant");
                Date debut = rs.getDate("dateDebut");
                Date fin = rs.getDate("dateFin");
                prevs.add(new Prevision(id, nom, montant, debut, fin));
            }
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
        return prevs;
    }

    public String getName(int idPrevision) throws SQLException {
        String sql = "SELECT nom "
                + "FROM Prevision "
                + "WHERE idPrevision = " + idPrevision;
        String nom = "";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                nom = rs.getString("nom");
            }
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
        return nom;
    }
}
