package dbmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDB {

	private static final DBConnect dbc = new DBConnect();

	public User getUser(String id, String password) {

		String sql = "SELECT * FROM user WHERE id = ? AND password = ?";

		try (Connection con = dbc.Connect(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, id);
			ps.setString(2, password);

			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {
					User u = new User();
					u.setId(rs.getString("id"));
					u.setPassword(rs.getString("password"));
					u.setName(rs.getString("name"));
					u.setPlay(rs.getInt("play"));
					u.setWin(rs.getInt("win"));
					u.setDraw(rs.getInt("draw"));
					u.setWinLate(rs.getDouble("win_rate"));

					return u;
				}

			}

		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	//id重複確認用
	public User getUser(String id) {

		String sql = "SELECT * FROM user WHERE id = ?";

		try (Connection con = dbc.Connect(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, id);

			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {
					User u = new User();
					u.setId(rs.getString("id"));
					u.setPassword(rs.getString("password"));
					u.setName(rs.getString("name"));
					u.setPlay(rs.getInt("play"));
					u.setWin(rs.getInt("win"));
					u.setDraw(rs.getInt("draw"));
					u.setWinLate(rs.getDouble("win_rate"));

					return u;
				}

			}

		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void insertUser(User user) {

		String sql = "INSERT INTO user set id = ?, password = ?, name = ?";

		try (Connection con = dbc.Connect(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, user.getId());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());

			ps.executeUpdate();

		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteUser(String id) {

		String sql = "DELETE FROM user WHERE id = ?";

		try (Connection con = dbc.Connect(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, id);

			ps.executeUpdate();

		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
