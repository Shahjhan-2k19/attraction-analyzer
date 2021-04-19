/* #2 control
 * FXMLDOCumentController is controlling the main screen button functions
 * when start button pressed on wellcome screen it loads dashboard.fxml
 * on each press it create new main page screen
 * From here my actual work starting (using scene not pane) 
 */
package attraction.analyzer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
 //variables   
    private Label label;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private Button btnstart;
    
   
   //initialize a controller after its root element has been completely processed.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    //mouse event to handle button action
    @FXML
    private void handleButtonAction(MouseEvent event) {
    }
    //action event call when button pressed open new page and load design from dashboard.fxml
    @FXML
    private void bt_load(ActionEvent event){
       try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = FXMLLoader.load(getClass().getResource("Dashbord.fxml"));
            stage.setScene(new Scene(root));
            
             
            stage.showAndWait();
       }
       catch ( IOException e)
       {
           e.printStackTrace();
       }
    }
    
}
