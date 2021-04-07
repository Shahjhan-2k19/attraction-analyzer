
package attraction.analyzer;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

public class Fact3Controller implements Initializable {

    @FXML
    private AreaChart<?, ?> area;
    @FXML
    private ScatterChart<?, ?> scat;

    
    public void initialize(URL url, ResourceBundle rb) {
    }
}
