package dbmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public Connection connect() throws ClassNotFoundException, SQLException {

		Connection con;

		Class.forName("org.mariadb.jdbc.Driver");

		String url = "jdbc:mariadb://localhost/blackjack_split";
		String user = "root";
		String password = "";

		con = DriverManager.getConnection(url, user, password);

		return con;
	}

}
