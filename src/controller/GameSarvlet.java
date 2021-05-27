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
import model.Player;
import model.User;

@WebServlet("/GameSarvlet")
public class GameSarvlet extends HttpServlet {
	private static final long serialVersionUID = -359485711102746206L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Player player = new Player();
		Dealer dealer = new Dealer();

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
			player.draw(deckInf);

			if (player.getBust()) {
				request.setAttribute("message", "Lose");
				session.setAttribute("player", player);
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				rd.forward(request, response);
			} else {
				session.setAttribute("player", player);
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				rd.forward(request, response);
			}

		}

		else if (command == 1) {

			dealer.draw(deckInf);

			if (dealer.getBust()) {
				request.setAttribute("message", "Win");
				session.setAttribute("dealer", dealer);
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				rd.forward(request, response);

			} else {

				if (player.getScore() > dealer.getScore()) {
					request.setAttribute("message", "Win");
					session.setAttribute("dealer", dealer);
					RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
					rd.forward(request, response);
				} else if (player.getScore() == dealer.getScore()) {
					request.setAttribute("message", "Draw");
					session.setAttribute("dealer", dealer);
					RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
					rd.forward(request, response);
				} else if (player.getScore() < dealer.getScore()) {
					request.setAttribute("message", "Lose");
					session.setAttribute("dealer", dealer);
					RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
					rd.forward(request, response);
				}

			}

		}

	}

}
