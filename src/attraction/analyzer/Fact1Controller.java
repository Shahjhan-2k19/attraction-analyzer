
package attraction.analyzer;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;


public class Fact1Controller implements Initializable {

    @FXML
    private BarChart<?, ?> places;
    @FXML
    private CategoryAxis y;
    @FXML
    private NumberAxis x;
public Connection getConnnection()
    {
        Connection conn;
        try{
            conn = DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/tour","root","root"); 
            return conn;
        }
        catch(Exception e)
        {
            System.out.println("Error : "+e.getMessage());
            return null;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection conn= this.getConnnection();
        String query1 = "Select count(*) as n  from attractions where Tags like \"%castle%\"";
        String query2 = "Select count(*) as o from attractions where Tags like \"%park%\"";
        String query3 = "Select count(*) as  p from attractions where Tags like \"%Art%\"";
        String query4 = "Select count(*) as q from attractions where Tags like \"%Museum%\"";
        String query5 = "Select count(*) as r from attractions where Tags like \"%stadium%\"";
        String query6 = "Select count(*) as s from attractions where Tags like \"%Agriculture%\"";
        Statement st1,st2,st3,st4,st5,st6 ;
        ResultSet rs1,rs2,rs3,rs4,rs5,rs6;
        int result1=0,result2=0,result3=0,result4=0,result5=0,result6=0;
        try {
            st1= conn.createStatement();
            rs1 = st1.executeQuery(query1);
            while(rs1.next())
                result1=rs1.getInt("n");
            
             st2= conn.createStatement();
            rs2 = st2.executeQuery(query2);
            while(rs2.next())
                result2=rs2.getInt("o");
            
             st3= conn.createStatement();
            rs3 = st3.executeQuery(query3);
            while(rs3.next())
                result3=rs3.getInt("p");
            
             st4= conn.createStatement();
            rs4 = st4.executeQuery(query4);
            while(rs4.next())
                result4=rs4.getInt("q");
            
             st5= conn.createStatement();
            rs5 = st5.executeQuery(query5);
            while(rs5.next())
                result5=rs5.getInt("r");
            
             st6= conn.createStatement();
            rs6 = st6.executeQuery(query6);
            while(rs6.next())
                result6=rs6.getInt("s");     
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

         XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data("Castles",result1));
        set1.getData().add(new XYChart.Data("Park",result2));
         set1.getData().add(new XYChart.Data("Art Gallery",result3));
        set1.getData().add(new XYChart.Data("Museums",result4));
        set1.getData().add(new XYChart.Data("stadiums",result5));
        set1.getData().add(new XYChart.Data("Agriculture",result6));
        
        places.getData().addAll(set1);
        
        
    }    
    
}
