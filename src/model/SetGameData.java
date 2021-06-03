package model;

import java.sql.Timestamp;

import dbmodel.GameDB;
import dbmodel.UserDB;

public class SetGameData {

	private WinLoseConvert wlc = new WinLoseConvert();
	private GameDB gdb = new GameDB();
	private UserDB udb = new UserDB();

	public User setData(User user, String judge) {

		if (judge != null) {

			Timestamp playTime = new Timestamp(System.currentTimeMillis());

			user.calcGameRecord(judge);
			Game game = new Game(user.getId(), wlc.StrConvert(judge), playTime);

			gdb.insertGame(game);
			udb.updateUserRecord(user);

		}

		return user;

	}

}
