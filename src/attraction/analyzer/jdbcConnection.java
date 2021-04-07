
package attraction.analyzer;
import java.sql.*; 
public class jdbcConnection {
    public jdbcConnection(){
    try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection conn=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/tour","root","root");   
            Statement stmt=conn.createStatement();  
            ResultSet rs=null;
    }
    catch(ClassNotFoundException | SQLException e){ 
        System.out.println("error "+e);
    }  
    }  
    
}
