package model;

import java.sql.Timestamp;

import dbmodel.GameDB;
import dbmodel.UserDB;
import entity.Game;
import entity.User;
import model.actor.Player;

public class SetGameData {

	private GameDB gdb = new GameDB();
	private UserDB udb = new UserDB();

	public User setData(User user, Player player) {

		if (!player.isGameEnd()) {
			return user;
		}

		Timestamp playTime = new Timestamp(System.currentTimeMillis());

		user.setChip(user.getChip() + player.getWinChip());
		user.setPlay(user.getPlay() + 1);

		Game game = new Game(user, player.getWinChip(), playTime);

		gdb.insertGame(game);
		udb.updateUserRecord(user);

		return user;

	}

}
