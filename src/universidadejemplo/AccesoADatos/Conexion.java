package universidadejemplo.AccesoADatos;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {

    private static final String URL = "jdbc:mariadb://localhost:3006/";
    private static final String DB = "universidadulp";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    private Conexion() {
    }

    ;
    public static Connection getConexion() {
        if (connection == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                try {
                    connection = DriverManager.getConnection(URL+DB,USUARIO,PASSWORD);
                    JOptionPane.showMessageDialog(null,"Conectado");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la conexion" + ex.getMessage());
                }

            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error en la carga del driver" + ex.getMessage());
            }

        }
        return connection;
    }

}
