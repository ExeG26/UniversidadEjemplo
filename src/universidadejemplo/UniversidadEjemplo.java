
package universidadejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.swing.*;


public class UniversidadEjemplo {

    
    public static void main(String[] args) {
        try {
            //driver de conexion
            Class.forName("org.mariadb.jdbc.Driver");
            //conexion a base de datos
            Connection conn=DriverManager.getConnection("jdbc:mariadb://localhost:3306/universidadulp", "root", "");

            String sql="insert into materia (nombre, año, estado)"
                    + "values ('Laboratorio 2',2,true), "
                    + "('Calculo 2',2,true), "
                    + "('Sociales',1,true),"
                    + "('Fisica',1,true)";
            
            PreparedStatement ps=conn.prepareStatement(sql);
            int filas=ps.executeUpdate();
            if(filas>0){
                JOptionPane.showMessageDialog(null, "Materia Agregada Exitosamente");
            }
            
        //////////////////////////////////////////////////////////
        //OBTENCION DE ERRORES
            
        } catch(ClassNotFoundException exe){
            JOptionPane.showMessageDialog(null,"Debe agregar los driver al proyecto");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de Coneccion");
        }
    }
    
}
