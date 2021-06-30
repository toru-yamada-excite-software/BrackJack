package dbmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.User;

public class UserDB {

	private static final DBConnect dbc = new DBConnect();

	//ログイン時ユーザー検索
	public User getUser(String id, String password) throws SQLException {

		String sql = "SELECT * FROM user WHERE id = ? AND password = ?";

		try (Connection con = dbc.connect(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, id);
			ps.setString(2, password);

			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {
					User u = new User();
					u.setId(rs.getString("id"));
					u.setPassword(rs.getString("password"));
					u.setName(rs.getString("name"));
					u.setPlay(rs.getInt("play"));
					u.setChip(rs.getInt("chip"));

					return u;
				}

			}

		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	//id重複確認用
	public boolean getUser(String id) {

		String sql = "SELECT * FROM user WHERE id = ?";

		try (Connection con = dbc.connect(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, id);

			try (ResultSet rs = ps.executeQuery();) {
				return rs.next();
			}

		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList<User> getRanking() {

		String sql = "SELECT * FROM user ORDER BY chip DESC LIMIT 10";
		ArrayList<User> userList = new ArrayList<User>();

		try (Connection con = dbc.connect();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				User u = new User();
				u.setId(rs.getString("id"));
				u.setPassword(rs.getString("password"));
				u.setName(rs.getString("name"));
				u.setPlay(rs.getInt("play"));
				u.setChip(rs.getInt("chip"));
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

	public int getMyRanking(String id) {

		String sql = "SELECT *,(SELECT COUNT(*)+1 FROM user B WHERE B.chip > A.chip) AS rank FROM user A WHERE id = ?";

		try (Connection con = dbc.connect();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, id);

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					int rank = rs.getInt("rank");
					return rank;
				}

			}

		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	//アカウント追加
	public void insertUser(User user) {

		String sql = "INSERT INTO user set id = ?, password = ?, name = ?";

		try (Connection con = dbc.connect(); PreparedStatement ps = con.prepareStatement(sql);) {

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

	//ユーザーニックネーム更新
	public void updateUserName(User user) {

		String sql = "UPDATE user set name = ? where id = ?";

		try (Connection con = dbc.connect(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, user.getName());
			ps.setString(2, user.getId());

			ps.executeUpdate();

		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//ユーザー戦績更新
	public void updateUserRecord(User user) {

		String sql = "UPDATE user set play = ?, chip = ? where id = ?";

		try (Connection con = dbc.connect(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, user.getPlay());
			ps.setInt(2, user.getChip());
			ps.setString(3, user.getId());

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

		try (Connection con = dbc.connect(); PreparedStatement ps = con.prepareStatement(sql);) {

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
