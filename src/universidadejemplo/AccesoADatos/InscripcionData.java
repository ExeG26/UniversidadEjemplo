package universidadejemplo.AccesoADatos;

import java.sql.*;
import universidadejemplo.Entidades.Inscripcion;

public class InscripcionData {
    
    
    
    private Connection con = null;
    private MateriaData matData;
    private AlumnoData aluData;

    public InscripcionData() {
        con = Conexion.getConexion();
    }
    
    public void guardarInscripcion(Inscripcion insc){
        String sql = "INSERT INTO Inscripcion(alumno, materia, nota) Values (?,?,?)";
        try{
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
        }catch(SQLException ex){
            System.out.println("a");
        }
    }
    
    public void obtenerMateriasCursadas(){
        
    }
}
