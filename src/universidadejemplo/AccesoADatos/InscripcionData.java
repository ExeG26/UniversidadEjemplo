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
        
    }
    
    public void obtenerMateriasCursadas(){
        
    }
}
