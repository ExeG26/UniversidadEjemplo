
package universidadejemplo.AccesoADatos;

import java.sql.*;
import javax.swing.JOptionPane;
import universidadejemplo.Entidades.Alumno;
import universidadejemplo.Entidades.Materia;

public class MateriaData {
    private Connection con;

    public MateriaData() {
    }
    
    public void guardarMateria(Materia materia){
        String sql = "INSERT INTO materia(nombre, anio, estado) "
                + "VALUES (null,'?','?','?')";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al guardar la materia");
        }
        
    }
    
    public Materia buscarMateria(int idMateria){
        String sql = "SELECT idMateria, nombre, anio, estado FROM materia WHERE idMateria = ? AND estado= 1";
        Materia materia = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                materia = new Materia();
                materia.setIdMateria(idMateria);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materia.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null,"No existe la materia a buscar");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla");
        }
        return materia;
    }
    
    public void modificarMateria(int idMateria){
        
        
    }
    
    public void eliminarMateria(int idMateria){
        
    }
}
