package model;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dbmodel.GameDB;
import dbmodel.UserDB;

public class GameManager {

	public HttpServletRequest GameManagement(HttpServletRequest request) {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Player player = (Player) session.getAttribute("player");
		Dealer dealer = (Dealer) session.getAttribute("dealer");
		Deck deckInf = (Deck) session.getAttribute("deckInf");
		int command = Integer.parseInt(request.getParameter("command"));

		if (command == 0) {

			deckInf = player.draw(deckInf);

			if (player.getBust()) {
				session.setAttribute("message", "Lose");
				session.setAttribute("player", player);
				Timestamp playTime = new Timestamp(System.currentTimeMillis());
				Game game = new Game();
				game.setUserId(user.getId());
				game.setWinLose(2);
				game.setPlayTime(playTime);
				GameDB gdb = new GameDB();
				gdb.insertGame(game);
				user.setPlay(user.getPlay() + 1);
				user.setWinRate((double) user.getWin() / user.getPlay());
				UserDB udb = new UserDB();
				udb.updateUserRecord(user);
				session.setAttribute("user", user);
				return request;
			} else {
				session.setAttribute("player", player);
				session.setAttribute("deckInf", deckInf);
				return request;
			}

		}

		else if (command == 1) {

			deckInf = dealer.draw(deckInf);

			if (dealer.getBust()) {

				session.setAttribute("message", "Win");
				session.setAttribute("dealer", dealer);
				Timestamp playTime = new Timestamp(System.currentTimeMillis());
				Game game = new Game();
				game.setUserId(user.getId());
				game.setWinLose(0);
				game.setPlayTime(playTime);
				GameDB gdb = new GameDB();
				gdb.insertGame(game);
				user.setPlay(user.getPlay() + 1);
				user.setWin(user.getWin() + 1);
				user.setWinRate((double) user.getWin() / user.getPlay());
				UserDB udb = new UserDB();
				udb.updateUserRecord(user);
				session.setAttribute("user", user);
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
					session.setAttribute("message", "Win");
					session.setAttribute("dealer", dealer);
					Timestamp playTime = new Timestamp(System.currentTimeMillis());
					Game game = new Game();
					game.setUserId(user.getId());
					game.setWinLose(0);
					game.setPlayTime(playTime);
					GameDB gdb = new GameDB();
					gdb.insertGame(game);
					user.setPlay(user.getPlay() + 1);
					user.setWin(user.getWin() + 1);
					user.setWinRate((double) user.getWin() / user.getPlay());
					UserDB udb = new UserDB();
					udb.updateUserRecord(user);
					session.setAttribute("user", user);
					return request;
				} else if (player.getScore() == dealer.getScore()) {
					session.setAttribute("message", "Draw");
					session.setAttribute("dealer", dealer);
					Timestamp playTime = new Timestamp(System.currentTimeMillis());
					Game game = new Game();
					game.setUserId(user.getId());
					game.setWinLose(1);
					game.setPlayTime(playTime);
					GameDB gdb = new GameDB();
					gdb.insertGame(game);
					user.setPlay(user.getPlay() + 1);
					user.setDraw(user.getDraw() + 1);
					user.setWinRate((double) user.getWin() / user.getPlay());
					UserDB udb = new UserDB();
					udb.updateUserRecord(user);
					session.setAttribute("user", user);
					return request;
				} else if (player.getScore() < dealer.getScore()) {
					session.setAttribute("message", "Lose");
					session.setAttribute("dealer", dealer);
					Timestamp playTime = new Timestamp(System.currentTimeMillis());
					Game game = new Game();
					game.setUserId(user.getId());
					game.setWinLose(2);
					game.setPlayTime(playTime);
					GameDB gdb = new GameDB();
					gdb.insertGame(game);
					user.setPlay(user.getPlay() + 1);
					user.setWinRate((double) user.getWin() / user.getPlay());
					UserDB udb = new UserDB();
					udb.updateUserRecord(user);
					session.setAttribute("user", user);
					return request;
				}

			}

		}

		return null;
	}

}
