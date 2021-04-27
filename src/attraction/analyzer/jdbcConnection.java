/*
 * connect with data base
 */

package attraction.analyzer;
import java.sql.*;

//class to get instance of jdbc connection to communicate with db
public class jdbcConnection {
	// method that returns jdbc connection instance for this purpose
    public jdbcConnection(){
    try{  
            Class.forName("com.mysql.jdbc.Driver"); // Driver Name 
            Connection conn=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/tourist","root","root"); // connection
			
            Statement stmt=conn.createStatement();  // statement object
            ResultSet rs=null;// resultset object
    }
    catch(ClassNotFoundException | SQLException e){ 
        System.out.println("error "+e);
    }  
    }  
    
}
