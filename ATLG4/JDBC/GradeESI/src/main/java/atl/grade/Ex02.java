package atl.grade;

import atl.grade.selection.*;
import atl.grade.Demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex02 extends Demo {

    @Override
    public void execute(String url) {
        try {
            Connection connexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            Statement stmt = connexion.createStatement();

            String query = "INSERT INTO Lessons(acronym) VALUES ('ANLL')";
            int count = stmt.executeUpdate(query);
            System.out.println("\t Nombre de record modifié : " + count);

            System.out.println("\n" + getTitle() + "\n");
            query = "SELECT acronym FROM Lessons";
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                System.out.println("\t Acronym : " + result.getString("acronym"));
            }

            System.out.println("\n" + getTitle() + "\n");
            query = "DELETE FROM Lessons WHERE acronym = 'ANLL'";
            count = stmt.executeUpdate(query);
            System.out.println("\t Nombre de record supprimé : " + count);

            System.out.println("\n" + getTitle() + "\n");
            query = "SELECT acronym FROM Lessons";
            result = stmt.executeQuery(query);
            while (result.next()) {
                System.out.println("\t Acronym : " + result.getString("acronym"));
            }

        } catch (SQLException ex) {
            System.out.println("DEMO_SELECT | Erreur " + ex.getMessage() + " SQLState " + ex.getSQLState());
        }
    }

    @Override
    public String getTitle() {
        return "Séparation de commande";
    }
}
