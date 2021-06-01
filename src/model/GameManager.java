package model;

import java.sql.Timestamp;

import dbmodel.GameDB;
import dbmodel.UserDB;

public class GameManager {

	GameInf gi;
	int command;

	public GameManager(GameInf gi, int command) {
		this.gi = gi;
		this.command = command;
	}

	public GameInf GameManagement() {

		Player player = gi.getPlayer();
		Dealer dealer = gi.getDealer();
		Deck deckInf = gi.getDeck();

		if (command == 0) {

			deckInf = player.draw(deckInf);

			if (player.getBust()) {

				//user = setDB(2, user);
				gi = new GameInf(player, dealer, deckInf, "Lose");
				//setSession(gi, user);
				return gi;

			} else {

				gi = new GameInf(player, dealer, deckInf, null);
				//setSession(gi, user);
				return gi;

			}

		}

		else if (command == 1) {

			deckInf = dealer.draw(deckInf);

			if (dealer.getBust()) {

				//user = setDB(0, user);
				gi = new GameInf(player, dealer, deckInf, "Win");
				//setSession(gi, user);
				return gi;

			} else {

				//A

				if (player.getScore() > dealer.getScore()) {

					//user = setDB(0, user);
					gi = new GameInf(player, dealer, deckInf, "Win");
					//setSession(gi, user);
					return gi;

				} else if (player.getScore() == dealer.getScore()) {

					//user = setDB(1, user);
					gi = new GameInf(player, dealer, deckInf, "Draw");
					//setSession(gi, user);
					return gi;

				} else if (player.getScore() < dealer.getScore()) {

					//user = setDB(2, user);
					gi = new GameInf(player, dealer, deckInf, "Lose");
					//setSession(gi, user);
					return gi;

				}

			}

		}

		return null;
	}

	public User setDB(int judge, User user) {

		Timestamp playTime = new Timestamp(System.currentTimeMillis());
		GameDB gdb = new GameDB();
		UserDB udb = new UserDB();
		Game game = new Game(user.getId(), judge, playTime);

		if (judge == 0) {
			user.setGameRecord(1, 1, 0, (double) user.getWin() / user.getPlay());
		} else if (judge == 1) {
			user.setGameRecord(1, 0, 1, (double) user.getWin() / user.getPlay());
		} else if (judge == 2) {
			user.setGameRecord(1, 0, 0, (double) user.getWin() / user.getPlay());
		}

		gdb.insertGame(game);
		udb.updateUserRecord(user);

		return user;
	}

	//	if (player.getAscore() > player.getScore()) {
	//	player.setScore(player.getAscore());
	//	player.setAscore(0);
	//}
	//
	//if (dealer.getAscore() > dealer.getScore()) {
	//	dealer.setScore(dealer.getAscore());
	//	dealer.setAscore(0);
	//}

}
