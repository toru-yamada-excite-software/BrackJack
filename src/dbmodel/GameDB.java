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

		try (Connection con = dbc.Connect(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, userId);

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					Game game = new Game();
					game.setId(rs.getInt("id"));
					game.setUserId(rs.getString("user_id"));
					game.setWinLose(rs.getInt("win_lose"));
					game.setPlayTime(rs.getDate("play_time"));
					gameList.add(game);
				}

				//				game = gameList.get(0);
				//				System.out.println(game.getId());

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

}
