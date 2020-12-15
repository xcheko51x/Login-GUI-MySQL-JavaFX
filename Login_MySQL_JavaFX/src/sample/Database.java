package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    static Connection conexion = null;

    public Connection obtenerConexion() {
        if(conexion == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/pruebas", "root", "");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return conexion;
    }

    public void cerrarConexion() {
        if(conexion != null) {
            try {
                conexion.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
