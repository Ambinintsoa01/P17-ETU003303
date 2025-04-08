package DAOobj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import objects.Etat;

public class DAOetat {

    private static final String URL = "jdbc:mysql://localhost:3306/db_s2_ETU003303";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public List<Etat> getAll() throws SQLException {
        List<Etat> etat = new ArrayList<>();
        String sql = "SELECT p.nom, SUM(d.montant) as Depense, (p.montant -  SUM(d.montant)) as Reste "
                + "FROM Depense d "
                + "JOIN Prevision p "
                + "ON p.idPrevision = d.idPrevision "
                + "WHERE d.dateDepense >= p.dateDebut AND d.dateDepense <= p.dateFin "
                + "GROUP BY d.idPrevision ORDER BY p.idPrevision ASC";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String nom = rs.getString("nom");
                int montant = rs.getInt("Depense");
                int reste = rs.getInt("Reste");
                etat.add(new Etat(nom, montant, reste));
            }
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
        return etat;
    }
}
