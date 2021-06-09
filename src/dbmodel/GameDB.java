package dbmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Game;

public class GameDB {

	private static final DBConnect dbc = new DBConnect();

	//ゲーム履歴取得
	public ArrayList<Game> getGame(String userId) {

		String sql = "SELECT * FROM game WHERE user_id = ? ORDER BY id DESC LIMIT 30";
		ArrayList<Game> gameList = new ArrayList<Game>();

		try (Connection con = dbc.connect(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, userId);

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					Game game = new Game(rs.getString("user_id"), rs.getInt("get_chip"), rs.getTimestamp("play_time"));
					game.setId(rs.getInt("id"));
					gameList.add(game);
				}

				return gameList;
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

	//ゲーム記録追加
	public void insertGame(Game game) {

		String sql = "INSERT INTO game SET user_id = ?, get_chip = ?, play_time = ?";

		try (Connection con = dbc.connect(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, game.getUserId());
			ps.setInt(2, game.getChip());
			ps.setTimestamp(3, game.getPlayTime());

			ps.executeUpdate();

		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//退会処理
	public void deleteGame(String userId) {

		String sql = "DELETE FROM game WHERE user_id = ?";

		try (Connection con = dbc.connect(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, userId);

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
