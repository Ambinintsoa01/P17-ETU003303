package DAOobj;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import objects.Depense;

public class DAOdepense {

    private static final String URL = "jdbc:mysql://localhost:3306/db_s2_ETU003303";
    private static final String USER = "ETU003303";
    private static final String PASSWORD = "";

    public boolean save(int idPrevision, int montant, Date depense) throws SQLException {
        String sql = "INSERT INTO Depense(idPrevision, montant, dateDepense) VALUES(?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPrevision);
            stmt.setInt(2, montant);
            stmt.setDate(3, depense);
            int rowSaved = stmt.executeUpdate();
            return rowSaved > 0;
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

    public List<Depense> getAll() throws SQLException {
        List<Depense> deps = new ArrayList<>();
        String sql = "SELECT * FROM Depense";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int idDepense = rs.getInt("idDepense");
                int idPrevision = rs.getInt("idPrevision");
                int montant = rs.getInt("montant");
                Date depense = rs.getDate("dateDepense");
                deps.add(new Depense(idDepense, idPrevision, montant, depense));
            }
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
        return deps;
    }

    public int getSumDepense() throws SQLException {
        String sql = "SELECT d.idPrevision, SUM(d.montant) "
                + "FROM Depense d "
                + "JOIN Prevision p "
                + "ON p.idPrevision = d.idPrevision "
                + "WHERE d.dateDepense >= p.dateDebut AND d.dateDepense <= p.dateFin "
                + "GROUP BY d.idPrevision";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement stmt = conn.prepareStatement(sql)) {
            int rowSaved = stmt.executeUpdate();
            return rowSaved;
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }
}
