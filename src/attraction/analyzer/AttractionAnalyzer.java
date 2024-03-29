/* #1 starting
 * Attraction.analyzer is my main class to create scene, and
 * it loads the main wellcome screen design from Dashboard.fxml 
 */

package attraction.analyzer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AttractionAnalyzer extends Application {
//to load FXMLDocument for wellcome screen
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
   
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
//main entry point of the app
    public static void main(String[] args) {
       launch(args);
      jdbcConnection newcon=new jdbcConnection();
	  //getting new JDBC connection by creating instance of jdbcConnection
      //class which contains all db connectivity implementation
    }
    
}
