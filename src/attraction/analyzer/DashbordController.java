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
      this.ShowRecord();
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

    public ObservableList<ViewHelper> getRecordList()
    {
        ObservableList<ViewHelper> ls= FXCollections.observableArrayList();
        Connection conn= this.getConnnection();
        String query = "Select * from attractions ";
        Statement st ;
        ResultSet rs;
        try {
            st= conn.createStatement();
            rs = st.executeQuery(query);
            ViewHelper hp;
            while(rs.next())
            {
                hp = new ViewHelper(rs.getString("Name"),rs.getString("Url"),rs.getString("Telephone"),rs.getString("Longitude"),rs.getString("Latitude"),rs.getString("AddressRegion"),rs.getString("AddressLocality"),rs.getString("AddressCountry"),rs.getString("Tags"));
                ls.add(hp);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ls;
    }
    public void ShowRecord()
    {
        ObservableList<ViewHelper> list =  this.getRecordList();
        f_name.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Name"));
        f_url.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Url"));
        f_telephone.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Telephone"));
        f_lat.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("latitude"));
        f_long.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("longitude"));
        f_region.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Region"));
        f_local.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Local"));
        f_country.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Country"));
        f_tag.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Tags"));
        Tb_view.setItems(list);
    }
public ObservableList<ViewHelper> getNameRecordList(String txt)
    {
        ObservableList<ViewHelper> ls= FXCollections.observableArrayList();
        Connection conn= this.getConnnection();
        String query = "Select * from attractions where Name like \"%"+txt+"%\"";
        Statement st ;
        ResultSet rs;
        try {
            st= conn.createStatement();
            rs = st.executeQuery(query);
            ViewHelper hp;
            while(rs.next())
            {
                hp = new ViewHelper(rs.getString("Name"),rs.getString("Url"),rs.getString("Telephone"),rs.getString("Longitude"),rs.getString("Latitude"),rs.getString("AddressRegion"),rs.getString("AddressLocality"),rs.getString("AddressCountry"),rs.getString("Tags"));
                ls.add(hp);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ls;
    }
    public void ShowNameRecord(String txt)
    {
        ObservableList<ViewHelper> list =  this.getNameRecordList(txt);
        f_name.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Name"));
        f_url.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Url"));
        f_telephone.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Telephone"));
        f_lat.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("latitude"));
        f_long.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("longitude"));
        f_region.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Region"));
        f_local.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Local"));
        f_country.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Country"));
        f_tag.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Tags"));
        Tb_view.setItems(list);
    }
    public ObservableList<ViewHelper> getRegionRecordList(String txt)
    {
        ObservableList<ViewHelper> ls= FXCollections.observableArrayList();
        Connection conn= this.getConnnection();
        String query = "Select * from attractions where AddressRegion like \"%"+txt+"%\"";
        Statement st ;
        ResultSet rs;
        try {
            st= conn.createStatement();
            rs = st.executeQuery(query);
            ViewHelper hp;
            while(rs.next())
            {
                hp = new ViewHelper(rs.getString("Name"),rs.getString("Url"),rs.getString("Telephone"),rs.getString("Longitude"),rs.getString("Latitude"),rs.getString("AddressRegion"),rs.getString("AddressLocality"),rs.getString("AddressCountry"),rs.getString("Tags"));
                ls.add(hp);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ls;
    }
    public void ShowRegionRecord(String txt)
    {
        ObservableList<ViewHelper> list =  this.getRegionRecordList(txt);
        f_name.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Name"));
        f_url.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Url"));
        f_telephone.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Telephone"));
        f_lat.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("latitude"));
        f_long.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("longitude"));
        f_region.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Region"));
        f_local.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Local"));
        f_country.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Country"));
        f_tag.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Tags"));
        Tb_view.setItems(list);
    }
    public ObservableList<ViewHelper> getTagRecordList(String txt)
    {
        ObservableList<ViewHelper> ls= FXCollections.observableArrayList();
        Connection conn= this.getConnnection();
        String query = "Select * from attractions where Tags like \"%"+txt+"%\"";
        Statement st ;
        ResultSet rs;
        try {
            st= conn.createStatement();
            rs = st.executeQuery(query);
            ViewHelper hp;
            while(rs.next())
            {
                hp = new ViewHelper(rs.getString("Name"),rs.getString("Url"),rs.getString("Telephone"),rs.getString("Longitude"),rs.getString("Latitude"),rs.getString("AddressRegion"),rs.getString("AddressLocality"),rs.getString("AddressCountry"),rs.getString("Tags"));
                ls.add(hp);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ls;
    }
    public void ShowTagRecord(String txt)
    {
        ObservableList<ViewHelper> list =  this.getTagRecordList(txt);
        f_name.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Name"));
        f_url.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Url"));
        f_telephone.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Telephone"));
        f_lat.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("latitude"));
        f_long.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("longitude"));
        f_region.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Region"));
        f_local.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Local"));
        f_country.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Country"));
        f_tag.setCellValueFactory(new PropertyValueFactory<ViewHelper,String>("Tags"));
        Tb_view.setItems(list);
    }
    @FXML
    private void searchByName(KeyEvent event) {
        this.ShowNameRecord(tx_name.getText());
        
    }

    @FXML
    private void searchByRegion(KeyEvent event) {
        this.ShowRegionRecord(tx_region.getText());
        
    }

    @FXML
    private void searchByTag(KeyEvent event) {
        this.ShowTagRecord(tx_tag.getText());
    }

    @FXML
    private void CalculateFact1(ActionEvent event) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = FXMLLoader.load(getClass().getResource("Fact1.fxml"));
            stage.setScene(new Scene(root));        
            stage.showAndWait();
       }
       catch ( IOException e)
       {
           e.printStackTrace();
       }
    }

    @FXML
    private void CalculateFact2(ActionEvent event) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = FXMLLoader.load(getClass().getResource("fact2.fxml"));
            stage.setScene(new Scene(root));        
            stage.showAndWait();
       }
       catch ( IOException e)
       {
           e.printStackTrace();
       }
    }

    @FXML
    private void CalculateFact3(ActionEvent event) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = FXMLLoader.load(getClass().getResource("fact3.fxml"));
            stage.setScene(new Scene(root));        
            stage.showAndWait();
       }
       catch ( IOException e)
       {
           e.printStackTrace();
       }
    }

    @FXML
    private void CalculateFact4(ActionEvent event) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = FXMLLoader.load(getClass().getResource("fact4.fxml"));
            stage.setScene(new Scene(root));        
            stage.showAndWait();
       }
       catch ( IOException e)
       {
           e.printStackTrace();
       }
    }

    @FXML
    private void searchByName(InputMethodEvent event) {
    }

  
}
