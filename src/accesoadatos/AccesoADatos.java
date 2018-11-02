package accesoadatos;

import accesoadatos.newpackage.Alumno;
import accesoadatos.newpackage.AlumnoData;
import accesoadatos.newpackage.Conexion;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
        
        
   



public class AccesoADatos {

  // Aca arranca la aplicacion 
    public static void main(String[] args) throws SQLException  {
        Conexion con = new Conexion();

        AlumnoData alumnoData = new AlumnoData(con);

        Alumno alumno1=new Alumno("juan lopez",LocalDate.of(2010,Month.DECEMBER,12),true);
        
        alumnoData.guardarAlumno(alumno1);
        

        System.out.println();
 //       try {
  //          String url="jdbc:mysql://localhost/prueba";
//            String usuario="root";
//            String password="";
//            Class.forName("org.mariadb.jdbc.Driver");
//            
//            Connection con= DriverManager.getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC" + "&user=" + usuario + "&password=" + password);
//       
//            PreparedStatement ps=con.prepareStatement
//           ("INSERT INTO Alumno (nombre,fecNac, activo) VALUES ( ?, ?, ?);");
//            
//            
//            ps.setString(1, "Sosa Juan");
//            
//            LocalDate nac=LocalDate.of(2018, Month.MARCH, 10);
//            ps.setDate(2, Date.valueOf(nac));
//                       
//            
//            ps.setBoolean(3, true);
//            int filas=ps.executeUpdate();
//            System.out.println("Filas agregadas "+filas);
//
//        
//    
//        
//        } catch (SQLException ex) {
//            Logger.getLogger(AccesoADatos.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(AccesoADatos.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
}
 