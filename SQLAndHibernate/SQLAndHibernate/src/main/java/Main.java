import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
        String user = "root";
        String pass = "Password";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM Courses");
            int number = 0;
            while (resultSet.next()) {
                number = Integer.parseInt(resultSet.getString("COUNT(*)"));
            }
            String name = "";
            double average = 0;
            for (int i = 1; i <= number; i++) {
                ResultSet resultSetName = statement.executeQuery("SELECT * FROM Courses WHERE id = " + i);
                while (resultSetName.next()) {
                    name = resultSetName.getString("name");
                }
                ResultSet resultSetAverage = statement.executeQuery("SELECT COUNT(*) / " +
                        "(MONTH(MAX(subscription_date)) - MONTH(MIN(subscription_date)) + 1) " +
                        "AS average FROM PurchaseList WHERE " +
                        "course_name = \"" + name + "\";");
                while (resultSetAverage.next()) {
                    average = resultSetAverage.getDouble("average");
                }
                System.out.println(name + " " + average);
            }

        } catch (Exception e) {
            System.out.println("exception");
        }
    }
}
