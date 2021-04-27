/* #3 control (used clear names for everything, its easy to follow)
 * dashboard controller controls buttons text field and tables 
 * FUNCTION call based on which text field has been used 
 */

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
// initializing buttons, Text Fields and Data Table
	// all the elements used in the building of the UI
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
    
   // method called at the creation of the dash board screen
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      this.ShowRecord();// method to fetch and show all the records in the db
	
    }  
	
    public Connection getConnnection()// function to build connection with database.and return connection variable
    {   
        Connection conn;
        try{
            conn = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/tourist", "root", "root"); 
            return conn;
        }
        catch(Exception e)
        {
            System.out.println("Error : "+e.getMessage());
            return null;
        }
    }
    // method to fetch all records from the attractions table
    public ObservableList<ViewHelper> getRecordList()
    {
        ObservableList<ViewHelper> ls= FXCollections.observableArrayList();// list to contain all records
        
        Connection conn= this.getConnnection();// connections instance to communicate with db
        //fetch all data
        String query = "Select * from attractions ";// query string to fetch record
        Statement st ;// statement variable declaration to create a query object for execution
        ResultSet rs;// result set variable declaration to store result of query
        try {
            st= conn.createStatement();// statement variable initialization
            rs = st.executeQuery(query);// executing the statement constructed by the query string and storing ressult
										// in resultset
			
            ViewHelper hp;// user defined object declaration to hold the data from the query
            while(rs.next())
            {
				// storing the data from the result set one by one
                hp = new ViewHelper(rs.getString("Name"),rs.getString("Url"),rs.getString("Telephone"),rs.getString("Longitude"),rs.getString("Latitude"),rs.getString("AddressRegion"),rs.getString("AddressLocality"),rs.getString("AddressCountry"),rs.getString("Tags"));
                // then adding t into the list
				ls.add(hp);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
		//returning the list
        return ls;
    }
    //showing over all data into list
    public void ShowRecord()
    {
        ObservableList<ViewHelper> list =  this.getRecordList();// call to method to get all records and store in a list
        // binding ui elements with the keys of objects in the list
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
    // method to fetch all records from the attractions table while Searching query
	// By Name 
    public ObservableList<ViewHelper> getNameRecordList(String txt)
    {
        ObservableList<ViewHelper> ls= FXCollections.observableArrayList();// list to contain all records
		
        Connection conn= this.getConnnection();// connections instance to communicate with db
		// fetch all data
        String query = "Select * from attractions where Name like \"%"+txt+"%\"";
        Statement st ;// statement variable declaration to create a query object for execution
        ResultSet rs;// result set variable declaration to store result of query
        try {
            st= conn.createStatement();// statement variable initialization
            rs = st.executeQuery(query);// executing the statement constructed by the query string and storing ressult
										// in resultset
            ViewHelper hp;// user defined object declaration to hold the data from the query
            while(rs.next())
            {
				// storing the data from the result set one by one
                hp = new ViewHelper(rs.getString("Name"),rs.getString("Url"),rs.getString("Telephone"),rs.getString("Longitude"),rs.getString("Latitude"),rs.getString("AddressRegion"),rs.getString("AddressLocality"),rs.getString("AddressCountry"),rs.getString("Tags"));
                // then adding t into the list
				ls.add(hp);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
		//returning the list
        return ls;
    }
    // showing over all data into list 
    public void ShowNameRecord(String txt)
    {
        ObservableList<ViewHelper> list =  this.getNameRecordList(txt);// call to method to get all records and store in a list
		// binding ui elements with the keys of objects in the list
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
    // method to fetch all records from the attractions table while Searching query
	// By Name 
    public ObservableList<ViewHelper> getRegionRecordList(String txt)
    {

        ObservableList<ViewHelper> ls= FXCollections.observableArrayList();// list to contain all records
        Connection conn= this.getConnnection();// connections instance to communicate with db
        String query = "Select * from attractions where AddressRegion like \"%"+txt+"%\"";// query string to fetch record
		
		Statement st;// statement variable declaration to create a query object for execution
		ResultSet rs;// result set variable declaration to store result of query
        try {
            st= conn.createStatement();// statement variable initialization
            rs = st.executeQuery(query);// executing the statement constructed by the query string and storing ressult
										// in resultset
            
			ViewHelper hp;// user defined object declaration to hold the data from the query
            while(rs.next())
            {
				// storing the data from the result set one by one
                hp = new ViewHelper(rs.getString("Name"),rs.getString("Url"),rs.getString("Telephone"),rs.getString("Longitude"),rs.getString("Latitude"),rs.getString("AddressRegion"),rs.getString("AddressLocality"),rs.getString("AddressCountry"),rs.getString("Tags"));
                // then adding it into the list
				ls.add(hp);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
		// returning the list
        return ls;
    }
    // showing over all data into list that is searched by Region
    public void ShowRegionRecord(String txt)
    {
        ObservableList<ViewHelper> list =  this.getRegionRecordList(txt);// call to method to get all records and store
		
		// binding ui elements with the keys of objects in the list
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
    // method to fetch all records from the attractions table while Searching query
	// By Tag
    public ObservableList<ViewHelper> getTagRecordList(String txt)
    {
        ObservableList<ViewHelper> ls= FXCollections.observableArrayList();// list to contain all records
        Connection conn= this.getConnnection();// connections instance to communicate with db
        
	   String query = "Select * from attractions where Tags like \"%"+txt+"%\"";// query string to fetch
		// record
        Statement st ;// statement variable declaration to create a query object for execution
        ResultSet rs;// result set variable declaration to store result of query
        try {
            st= conn.createStatement();// statement variable initialization
            rs = st.executeQuery(query);// executing the statement constructed by the query string and storing ressult
										// in resultset
			
            ViewHelper hp;// user defined object declaration to hold the data from the query
            while(rs.next())
            {
				// storing the data from the result set one by one
                hp = new ViewHelper(rs.getString("Name"),rs.getString("Url"),rs.getString("Telephone"),rs.getString("Longitude"),rs.getString("Latitude"),rs.getString("AddressRegion"),rs.getString("AddressLocality"),rs.getString("AddressCountry"),rs.getString("Tags"));
                // then adding it into the list
				ls.add(hp);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
		// returning the list
        return ls;
    }
    // showing over all data into list that is searched by Tag
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
	
	// method called on key press and filtering data by name
    @FXML
    private void searchByName(KeyEvent event) {
        this.ShowNameRecord(tx_name.getText());
        
    }
	
	// method called on key press and filtering data by Region
    @FXML
    private void searchByRegion(KeyEvent event) {
        this.ShowRegionRecord(tx_region.getText());
        
    }
	
	// method called on key press and filtering data by Tag
    @FXML
    private void searchByTag(KeyEvent event) {
        this.ShowTagRecord(tx_tag.getText());
    }
    // method called on fact1 button press and show new page with fact figure 1
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
   // method called on fact2 button press and show new page with fact figure 2
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
   // method called on fact3 button press and show new page with fact figure 3
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
   // method called on fact4 button press and show new page with fact figure 4
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
    //input method
    @FXML
    private void searchByName(InputMethodEvent event) {
    }

  
}
