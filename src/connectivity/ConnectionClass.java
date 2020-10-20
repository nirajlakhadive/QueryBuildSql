package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/**
 *
 */
public class ConnectionClass {

	public  Connection connection ;

	public Connection getConnection() throws Exception{

		String userName = "root";
		String password = "Special1!";
		String url = "jdbc:mysql://127.0.0.1:3306/student";
		
		

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection = DriverManager.getConnection(url,userName,password);
					Statement st = connection.createStatement();
					st.close();
					System.out.println("Successfully connected");
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Connection Failed");
				}



		return connection;
		
		
	}
}
