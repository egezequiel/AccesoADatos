/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos.newpackage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author programador
 */
public class AlumnoData {
    private Connection con ;
    public AlumnoData (Conexion conexion){
    con=conexion.getConexion();
    
    }
    
    public void guardarAlumno(Alumno alumno)  {
        try {
            String sql ="INSERT INTO alumno (nombre, fecNac, activo) VALUES ( ?, ?, ?);"; 
            
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, alumno.getNombre());
            ps.setDate(2, Date.valueOf(alumno.getFecNac()));
            ps.setBoolean(3, alumno.getActivo);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
          
            
            if (rs.next()){
                alumno.setId(rs.getInt("id"));
                
            }else{
                System.out.println("No se obtiene el id de alumno");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarAlumno(int id){
        
        try {
            String sql="DELATE FROM alumno WHERE id =?;";
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1,id);
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    
    
    
   
      
     public void actualizarAlumno(Alumno alumno){
     
    
        try {
            String sql ="UPDATE alumno SET nombre=?,fecNac =?,activo =? WHERE id =?;";
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, alumno.getNombre());
            
            ps.setDate(2, Date.valueOf(alumno.getFecNac()));
            
            ps.setBoolean(3, alumno.getActivo);
            
            ps.setInt(4,alumno.getId());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
            
     
     }
     public Alumno buscarAlumno(int id){
          Alumno alumno=null;
        try {
           
            
            String sql = "SELEC * FROM alumno WHERE id=?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            
            ResultSet resultSet=ps.executeQuery();
            
            while(resultSet.next()){
                alumno = new Alumno();
                alumno.setId(resultSet.getInt("id"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setFecNac(resultSet.getDate("facNac").toLocalDate());
                
            }  
        
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumno;
     
    }       
     public List<Alumno> obtenerAlumnos(){
     List<Alumno> alumnos = new ArrayList<>();
try {


String sql = "SELECT * FROM alumno;";
PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
ResultSet resultSet = ps.executeQuery();
Alumno alumno;


while(resultSet.next()){
try {
alumno = new Alumno();
alumno.setId(resultSet.getInt("id"));
alumno.setNombre(resultSet.getString("nombre"));
alumno.setFecNac(resultSet.getDate("fecNac").toLocalDate());
alumno.setActivo(resultSet.getBoolean("activo"));
//agregamos los alumnos ala lista 
alumnos.add(alumno);
ps.close();
} catch (SQLException ex) {
Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
}

}
} catch (SQLException ex) {
Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex); 
}
//rertornamos la tabla
return alumnos;
}  
}
    
    
    

