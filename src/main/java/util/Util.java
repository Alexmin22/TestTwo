package util;

import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String USER = "root";
    private static final String PASSWORD = "Gfrhjdcrbq63505";
    private static final String URL = "jdbc:mysql://localhost:3306/user";

    private Util() {}

    public static SessionFactory createUtilConnection() {
        Configuration configuration = new Configuration().addAnnotatedClass(User.class);
        return configuration.buildSessionFactory();
    }

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            System.out.println("Соеденение не установлено...");
            throw e;
        }
    }
}
