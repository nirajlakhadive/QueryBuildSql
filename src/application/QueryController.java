package application;

import connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class QueryController implements Initializable {

	@FXML 
	public Label textLabel;
	@FXML 
	public TextField textField;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}



	@FXML public void button(ActionEvent actionEvent) throws SQLException {
		try {

			ConnectionClass connectionClass = new ConnectionClass();
			Connection connection = connectionClass.getConnection();
			String sql = "INSERT INTO PERSONAL_DETAILS VALUES ('" + textField.getText() + "')";
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);

			sql = "SELECT * FROM PERSONAL_DETAILS; ";
			ResultSet resultset = statement.executeQuery(sql);
			while (resultset.next()){
				textLabel.setText(resultset.getString(1));
			}



		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Controller class failure");
		}
	}
	}
	
	
	



	
	

