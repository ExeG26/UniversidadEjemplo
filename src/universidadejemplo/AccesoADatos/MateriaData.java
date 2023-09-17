
package universidadejemplo.AccesoADatos;

import java.sql.*;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import universidadejemplo.Entidades.Materia;

public class MateriaData {

    private Connection con;

    public MateriaData() {
        con = Conexion.getConexion();
    }

    public void guardarMateria(Materia materia) {
        String sql = "INSERT INTO materia(nombre, anio, estado) "
                + "VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());

            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {

                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia guardada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la materia");
        }
    }

    public Materia buscarMateria(int idMateria) {
        String sql = "SELECT idMateria, nombre, anio, estado FROM materia WHERE idMateria = ? AND estado= 1";
        Materia materia = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(idMateria);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materia.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe la materia a buscar");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla");
        }
        return materia;
    }

    public void modificarMateria(Materia materia) {
        String sql = "UPDATE materia SET nombre=?,anio=?,estado=?"
                + " WHERE idMateria=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,materia.getNombre());
            ps.setInt(2,materia.getAnio());
            ps.setBoolean(3,materia.isEstado());
            int registro = ps.executeUpdate();
            System.out.println(registro);
            if(registro == 1){
                JOptionPane.showMessageDialog(null,"Materia modificada");
            }else{
                JOptionPane.showMessageDialog(null,"La materia no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la materia" + ex.getMessage());
        }
    }

    public void eliminarMateria(int idMateria) {
        
//        String sql = "DELETE FROM materia WHERE idMateria = ?";
//        PreparedStatement ps;
//        try {
//            ps = con.prepareStatement(sql);
//            int registro = ps.executeUpdate();
//            System.out.println(registro);
//            if(registro == 1){
//                JOptionPane.showMessageDialog(null,"Se eliminó la materia");
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,"Error al eliminar la materia" + ex.getMessage());
//        }
         String sql = "UPDATE materia SET estado = 0 WHERE idmateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            //ps.setInt(1, id);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia Inactiva");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia");

        }
    }

    public void reactivarMateria(int id) {
        String sql = "UPDATE materia SET estado = 1 WHERE idmateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia reactivada");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia");

        }

}
    
    public List<Materia> ListarMateria() {

        String sql = "SELECT  idmateria, nombre, anio FROM materia WHERE estado=1 "; 
        ArrayList<Materia> materias = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){

                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idmateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(true);
                
                materias.add(materia);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
        return materias;
    }
}


