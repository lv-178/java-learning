import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/courses?useSSL=false&serverTimezone=UTC&characterEncoding=utf8"; //&serverTimezone=UTC&characterEncoding=utf8
        String user = "root";
        String pass = "Password";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SHOW TABLES;");

            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
            SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();
//            Student student1 = new Student();
//            Course course1 = new Course();
//            Teacher teacher1 = new Teacher();
//            Purchase purchase1 = new Purchase();
//            session.save(student1);
//            session.save(course1);
//            session.save(teacher1);
//            session.save(purchase1);
            transaction.commit();

//            statement.execute("courses < skillboxdumpwfk.sql");

            sessionFactory.close();

        } catch (Exception e) {
            System.out.println("exception");
            e.printStackTrace();
        }
    }
}
