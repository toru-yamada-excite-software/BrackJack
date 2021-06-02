package model;

import java.sql.Timestamp;

import dbmodel.GameDB;
import dbmodel.UserDB;

public class SetGameDate {

	public User setDate(User user, String judge) {

		if (judge != null) {

			Timestamp playTime = new Timestamp(System.currentTimeMillis());
			GameDB gdb = new GameDB();
			UserDB udb = new UserDB();
			Game game = new Game(null, 0, null);

			if (judge.equals("Win")) {
				user.setGameRecord(1, 1, 0, (double) (user.getWin() + 1) / (user.getPlay() + 1));
				game = new Game(user.getId(), 0, playTime);
			} else if (judge.equals("Draw")) {
				user.setGameRecord(1, 0, 1, (double) user.getWin() / (user.getPlay() + 1));
				game = new Game(user.getId(), 1, playTime);
			} else if (judge.equals("Lose")) {
				user.setGameRecord(1, 0, 0, (double) user.getWin() / (user.getPlay() + 1));
				game = new Game(user.getId(), 2, playTime);
			}

			gdb.insertGame(game);
			udb.updateUserRecord(user);

		}

		return user;

	}

}
