import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kvetinarstvi",
                "root", "Roman8106");

        Statement statement = connection.createStatement();

        statement.executeUpdate(
                "insert into tabulka_kvetin (name, color, isToxic) values ('Fialka', 'Fialová', '0')");
        statement.executeUpdate(
                "insert into tabulka_kvetin (name, isToxic) values ('Lilie', '1')");
        statement.executeUpdate(
                "insert into tabulka_kvetin (name, isToxic) values ('Narcis', '1')");
        statement.executeUpdate(
                "insert into tabulka_kvetin (name) values ('Bledule')");

        statement.executeUpdate(
                "insert into tabulka_kvetin (name, isToxic) values ('Kopretina', '0')");
        statement.executeUpdate(
                "update tabulka_kvetin set description = " +
                    "('Pozor na cibulku - obsahuje největší koncentraci jedu'), " +
                    "isToxic = 1 where (name) = ('Bledule')");
        statement.executeUpdate(
                "delete from tabulka_kvetin where isToxic = 0");


        ResultSet resultset = statement.executeQuery(
                "select * from tabulka_kvetin");

        while (resultset.next()) {
            System.out.println(resultset.getString("name"));
        }


    }
}