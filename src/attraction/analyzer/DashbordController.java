package attraction.analyzer;
import attraction.analyzer.ViewHelper;
import attraction.analyzer.jdbcConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DashbordController implements Initializable {

    @FXML
    private Button btn_1;
    @FXML
    private Button btn_2;
    @FXML
    private Button btn_3;
    @FXML
    private Button btn_4;
    @FXML
    private TextField tx_region;
    @FXML
    private TextField tx_tag;
    @FXML
    private TextField tx_name;
    @FXML
    private TableView<ViewHelper> Tb_view;
    @FXML
   private TableColumn<ViewHelper, String> f_name;
    @FXML
    private TableColumn<ViewHelper, String> f_url;
    @FXML
    private TableColumn<ViewHelper, String> f_telephone;
    @FXML
    private TableColumn<ViewHelper, String> f_long;
    @FXML
    private TableColumn<ViewHelper, String> f_lat;
    @FXML
    private TableColumn<ViewHelper, String> f_region;
    @FXML
    private TableColumn<ViewHelper, String> f_local;
    @FXML
    private TableColumn<ViewHelper, String> f_country;
    @FXML
    private TableColumn<ViewHelper, String> f_tag;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }  
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

    
 

   
    

  
}
