package controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbmodel.GameDB;
import dbmodel.UserDB;
import model.Dealer;
import model.Deck;
import model.Game;
import model.Player;
import model.User;

@WebServlet("/GameServlet")
public class GameSarvlet extends HttpServlet {
	private static final long serialVersionUID = -359485711102746206L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		session.setAttribute("message", null);

		Player player = new Player();
		Dealer dealer = new Dealer();
		Deck deckInf = new Deck();
		deckInf.createDeck();

		deckInf = dealer.firstDraw(deckInf);
		deckInf = player.firstDraw(deckInf);

		if (dealer.getAscore() == 21 || player.getAscore() == 21) {

			if (dealer.getAscore() == 21 && player.getAscore() == 21) {

				session.setAttribute("message", "Draw");
				session.setAttribute("player", player);
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
				UserDB udb = new UserDB();
				udb.updateUserRecord(user);
				session.setAttribute("user", user);
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				rd.forward(request, response);

			} else if (dealer.getAscore() == 21) {

				session.setAttribute("message", "Lose");
				session.setAttribute("player", player);
				session.setAttribute("dealer", dealer);
				Timestamp playTime = new Timestamp(System.currentTimeMillis());
				Game game = new Game();
				game.setUserId(user.getId());
				game.setWinLose(2);
				game.setPlayTime(playTime);
				GameDB gdb = new GameDB();
				gdb.insertGame(game);
				user.setPlay(user.getPlay() + 1);
				UserDB udb = new UserDB();
				udb.updateUserRecord(user);
				session.setAttribute("user", user);
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				rd.forward(request, response);

			} else {

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
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				rd.forward(request, response);

			}

		}

		session.setAttribute("player", player);
		session.setAttribute("dealer", dealer);
		session.setAttribute("deckInf", deckInf);
		RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Player player = (Player) session.getAttribute("player");
		Dealer dealer = (Dealer) session.getAttribute("dealer");
		Deck deckInf = (Deck) session.getAttribute("deckInf");
		int command = Integer.parseInt(request.getParameter("command")); //command 0:hit 1:stand

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
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				rd.forward(request, response);
			} else {
				session.setAttribute("player", player);
				session.setAttribute("deckInf", deckInf);
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				rd.forward(request, response);
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
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				rd.forward(request, response);

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
					RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
					rd.forward(request, response);
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
					RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
					rd.forward(request, response);
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
					RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
					rd.forward(request, response);
				}

			}

		}

	}

}
