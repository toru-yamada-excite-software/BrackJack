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

@WebServlet("/StartGameServlet")
public class StartGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1880424086018231879L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
				Game game = new Game(user.getId(), 1, playTime);
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
				Game game = new Game(user.getId(), 2, playTime);
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
				Game game = new Game(user.getId(), 0, playTime);
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

}
