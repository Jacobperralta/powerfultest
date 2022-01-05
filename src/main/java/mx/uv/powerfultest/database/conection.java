package mx.uv.powerfultest.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conection {
    private String url = "jdbc:mysql://dbfree.net::3306/powerfultest";
    private String driverName = "com.mysql.jdbc.Driver";
    private String user = "root2395";
    private String password = "3..g2cD!PB6U4Tu";
    private Connection con = null;

    public Connection getConnection(){
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Listo!");
        } catch (SQLException e) {
            System.out.println("Fallo!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado");
            e.printStackTrace();
        }
        return con;
    }
}
