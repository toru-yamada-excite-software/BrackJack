package model;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dbmodel.GameDB;
import dbmodel.UserDB;

public class GameManager {

	HttpServletRequest request;
	HttpSession session;

	public GameManager(HttpServletRequest request) {
		this.request = request;
		session = request.getSession();
	}

	public HttpServletRequest GameManagement() {

		User user = (User) session.getAttribute("user");
		Player player = (Player) session.getAttribute("player");
		Dealer dealer = (Dealer) session.getAttribute("dealer");
		Deck deckInf = (Deck) session.getAttribute("deckInf");
		int command = Integer.parseInt(request.getParameter("command"));
		GameInf gi = new GameInf(player, dealer, deckInf, null);

		if (command == 0) {

			deckInf = player.draw(deckInf);

			if (player.getBust()) {

				user = setDB(2, user);
				gi = new GameInf(player, dealer, deckInf, "Lose");
				setSession(gi, user);
				return request;

			} else {

				gi = new GameInf(player, dealer, deckInf, null);
				setSession(gi, user);
				return request;

			}

		}

		else if (command == 1) {

			deckInf = dealer.draw(deckInf);

			if (dealer.getBust()) {

				user = setDB(0, user);
				gi = new GameInf(player, dealer, deckInf, "Win");
				setSession(gi, user);
				return request;

			} else {

				if (player.getAscore() > player.getScore()) {
					player.setScore(player.getAscore());
					player.setAscore(0);
				}

				if (dealer.getAscore() > dealer.getScore()) {
					dealer.setScore(dealer.getAscore());
					dealer.setAscore(0);
				}

				if (player.getScore() > dealer.getScore()) {

					user = setDB(0, user);
					gi = new GameInf(player, dealer, deckInf, "Win");
					setSession(gi, user);
					return request;

				} else if (player.getScore() == dealer.getScore()) {

					user = setDB(1, user);
					gi = new GameInf(player, dealer, deckInf, "Draw");
					setSession(gi, user);
					return request;

				} else if (player.getScore() < dealer.getScore()) {

					user = setDB(2, user);
					gi = new GameInf(player, dealer, deckInf, "Lose");
					setSession(gi, user);
					return request;

				}

			}

		}

		return null;
	}

	public void setSession(GameInf gi, User user) {

		session.setAttribute("player", gi.getPlayer());
		session.setAttribute("dealer", gi.getDealer());
		session.setAttribute("deckInf", gi.getDeck());
		session.setAttribute("message", gi.getMessage());
		session.setAttribute("user", user);

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

}
