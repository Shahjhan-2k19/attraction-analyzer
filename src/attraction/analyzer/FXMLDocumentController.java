/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    private Label label;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private Button btnstart;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }

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
