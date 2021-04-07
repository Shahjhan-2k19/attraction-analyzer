
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

    public void initialize(URL url, ResourceBundle rb) {
       
        
        
    }    
    
}
