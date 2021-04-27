/*
 * Fact 2 chart based on 6 region pre writen queries
 */

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
import javafx.scene.chart.PieChart;

//controller class for fact 2
public class Fact2Controller implements Initializable {
	// UI elements decleration
	@FXML
	private PieChart pie;

	// method to create connection and return connection object
	public Connection getConnnection() {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tour", "root", "root");
			return conn;
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			return null;
		}
	}

	// method invoked at the creation of the UIscreen for fact 2
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Connection conn = this.getConnnection();
		// different queries to get different data to generate the fact
		String query1 = "Select count(*) as n  from attractions where AddressRegion like \"%Dublin%\"";
		String query2 = "Select count(*) as o from attractions where AddressRegion like \"%Cork%\"";
		String query3 = "Select count(*) as  p from attractions where AddressRegion like \"%Donegal%\"";
		String query4 = "Select count(*) as q from attractions where AddressRegion like \"%Laois%\"";
		String query5 = "Select count(*) as r from attractions where AddressRegion like \"%Mayo%\"";
		String query6 = "Select count(*) as s from attractions where AddressRegion like \"%Longford%\"";
		Statement st1, st2, st3, st4, st5, st6;// multiple statement object declarations to execute multiple queries
		ResultSet rs1, rs2, rs3, rs4, rs5, rs6;// multiple result set declarations to hold data for each query
		// variables initialized to default value to store data from result set
		int result1 = 0, result2 = 0, result3 = 0, result4 = 0, result5 = 0, result6 = 0;
		try {
			// execution of all above queries and storing data in different variables
			st1 = conn.createStatement();
			rs1 = st1.executeQuery(query1);
			while (rs1.next())
				result1 = rs1.getInt("n");

			st2 = conn.createStatement();
			rs2 = st2.executeQuery(query2);
			while (rs2.next())
				result2 = rs2.getInt("o");

			st3 = conn.createStatement();
			rs3 = st3.executeQuery(query3);
			while (rs3.next())
				result3 = rs3.getInt("p");

			st4 = conn.createStatement();
			rs4 = st4.executeQuery(query4);
			while (rs4.next())
				result4 = rs4.getInt("q");

			st5 = conn.createStatement();
			rs5 = st5.executeQuery(query5);
			while (rs5.next())
				result5 = rs5.getInt("r");

			st6 = conn.createStatement();
			rs6 = st6.executeQuery(query6);
			while (rs6.next())
				result6 = rs6.getInt("s");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// setting all the data fetched above in the diagram
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Dublin", result1), new PieChart.Data("Cork", result2),
				new PieChart.Data("Donegal", result3), new PieChart.Data("Laois", result4),
				new PieChart.Data("Mayo", result5), new PieChart.Data("Longford", result6));

		pie.setData(pieChartData);

	}

}
