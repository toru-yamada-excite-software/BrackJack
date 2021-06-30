package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import model.GameInf;
import model.SetGameData;
import model.actor.Dealer;
import model.actor.Player;
import model.card.Deck;

@WebServlet("/StartGameServlet")
public class StartGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1880424086018231879L;

	private SetGameData sgd = new SetGameData();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int betChip = Integer.parseInt(request.getParameter("betChip"));

		Deck deck = new Deck();
		Player player = new Player(deck, betChip);
		Dealer dealer = new Dealer(deck);

		GameInf gi = new GameInf(player, dealer, deck);
		gi.setResultNaturalBlackjack();

		user = sgd.setData(user, gi.getPlayer());

		session.setAttribute("gameInf", gi);
		session.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("mainMenu.jsp");
		rd.forward(request, response);

	}

}