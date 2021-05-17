package dbmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public Connection Connect() throws ClassNotFoundException, SQLException {

		Connection con;

		Class.forName("org.mariadb.jdbc.Driver");

		String url = "jdbc:mariadb://localhost/brackjack";
		String user = "root";
		String password = "";

		con = DriverManager.getConnection(url, user, password);

		return con;
	}

}
