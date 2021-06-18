package model;

import java.sql.Timestamp;

import dbmodel.GameDB;
import dbmodel.UserDB;

public class SetGameData {

	private GameDB gdb = new GameDB();
	private UserDB udb = new UserDB();

	public User setData(User user, Player player) {

		if (JudgeGameEnd.judge(player) == player.getHandList().size()) {

			Timestamp playTime = new Timestamp(System.currentTimeMillis());

			Game game = new Game(user.getId(), (player.getChip() - user.getChip()), playTime);
			user.setChip(player.getChip());
			user.setPlay(user.getPlay() + 1);

			gdb.insertGame(game);
			udb.updateUserRecord(user);

		}

		return user;

	}

}
