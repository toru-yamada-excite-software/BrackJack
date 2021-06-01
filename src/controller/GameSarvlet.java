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
import model.User;

@WebServlet("/GameServlet")
public class GameSarvlet extends HttpServlet {
	private static final long serialVersionUID = -359485711102746206L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		Player player = (Player) session.getAttribute("player");
		Dealer dealer = (Dealer) session.getAttribute("dealer");
		Deck deckInf = (Deck) session.getAttribute("deckInf");
		int command = Integer.parseInt(request.getParameter("command"));

		GameInf gi = new GameInf(player, dealer, deckInf, null);

		GameManager gm = new GameManager(gi, command);
		gi = gm.GameManagement();

		session.setAttribute("gameInf", gi);

		RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
		rd.forward(request, response);

	}

}
