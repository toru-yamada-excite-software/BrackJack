package model;

import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dbmodel.GameDB;
import dbmodel.UserDB;

public class GameManager {

	public void GameManagement(HttpServletRequest request) {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Player player = (Player) session.getAttribute("player");
		Dealer dealer = (Dealer) session.getAttribute("dealer");
		Deck deck = (Deck) session.getAttribute("deckInf");
		int command = Integer.parseInt(request.getParameter("command"));

		if (command == 0) {

			deck = player.draw(deck);

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
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				rd.forward(request, response);
			} else {
				session.setAttribute("player", player);
				session.setAttribute("deckInf", deckInf);
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				rd.forward(request, response);
			}

		}

	}

}
