package dbmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Game;

public class GameDB {

	private static final DBConnect dbc = new DBConnect();

	public ArrayList<Game> getGame(String userId) {

		String sql = "SELECT * FROM game WHERE user_id = ?";
		ArrayList<Game> gameList = new ArrayList<Game>();

		try (Connection con = dbc.connect(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, userId);

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					Game game = new Game();
					game.setId(rs.getInt("id"));
					game.setUserId(rs.getString("user_id"));
					game.setWinLose(rs.getInt("win_lose"));
					game.setPlayTime(rs.getTimestamp("play_time"));
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

		public void insertGame(Game game) {

			String sql = "INSERT INTO game SET user_id = ?, win_lose = ?, play_time = ?";

			try (Connection con = dbc.connect(); PreparedStatement ps = con.prepareStatement(sql);) {

				ps.setString(1, game.getUserId());
				ps.setInt(2, game.getWinLose());
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
