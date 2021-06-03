package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Dealer;
import model.Deck;
import model.GameInf;
import model.GameManager;
import model.Player;
import model.SetGameData;
import model.User;

@WebServlet("/StartGameServlet")
public class StartGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1880424086018231879L;

	GameManager gm = new GameManager(0);
	SetGameData sgd = new SetGameData();

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

		GameInf gi = new GameInf(player, dealer, deckInf, null);

		gi = gm.naturalBJ(gi);
		user = sgd.setData(user, gi.getMessage());

		session.setAttribute("gameInf", gi);
		session.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
		rd.forward(request, response);

	}

}