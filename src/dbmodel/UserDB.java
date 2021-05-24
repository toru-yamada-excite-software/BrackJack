package dbmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;

public class UserDB {

	private static final DBConnect dbc = new DBConnect();

	//ログイン時ユーザー検索
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

	public ArrayList<User> getRanking() {

		String sql = "SELECT * FROM user ORDER BY win_rate DESC LIMIT 10";
		ArrayList<User> userList = new ArrayList<User>();

		try (Connection con = dbc.Connect();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {

			User u = new User();

			while (rs.next()) {
				u.setId(rs.getString("id"));
				u.setPassword(rs.getString("password"));
				u.setName(rs.getString("name"));
				u.setPlay(rs.getInt("play"));
				u.setWin(rs.getInt("win"));
				u.setDraw(rs.getInt("draw"));
				u.setWinLate(rs.getDouble("win_rate"));
				userList.add(u);
			}

			return userList;
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	//アカウント追加
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

	//ユーザー情報更新
	public void updateUser(User user) {

		String sql = "UPDATE user set name = ?, play = ?, win = ?, draw = ?, win_rate = ? where id = ?";

		try (Connection con = dbc.Connect(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, user.getName());
			ps.setInt(2, user.getPlay());
			ps.setInt(3, user.getWin());
			ps.setInt(4, user.getDraw());
			ps.setDouble(5, user.getWinLate());
			ps.setString(6, user.getId());

			ps.executeUpdate();

		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//アカウント削除
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
