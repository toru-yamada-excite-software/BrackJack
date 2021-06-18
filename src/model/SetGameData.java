package model;

import java.sql.Timestamp;

import dbmodel.GameDB;
import dbmodel.UserDB;

public class SetGameData {

	private GameDB gdb = new GameDB();
	private UserDB udb = new UserDB();

	public User setData(User user, Player player) {

		int judgeEnd = 0;

		for (int i = 0; i < player.getHandList().size(); i++) {
			if (player.getHandList().get(i).getResult() != null) {
				judgeEnd++;
			}
		}

		if (judgeEnd == player.getHandList().size()) {

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
