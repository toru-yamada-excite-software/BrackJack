package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Card;
import model.GameInf;
import model.Player;

@WebServlet("/SplitServlet")
public class SplitServlet extends HttpServlet {
	private static final long serialVersionUID = -7841258715078384688L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		GameInf gi = (GameInf) session.getAttribute("gameInf");
		Player player = gi.getPlayer();
		Player splitPlayer = new Player();

		Card card = player.getHand().poll();
		splitPlayer.setHand(card);
		player.scoreCalc();
		splitPlayer.scoreCalc();

		gi.setPlayer(player);
		gi.setSplitPlayer(splitPlayer);
		session.setAttribute("gameInf", gi);
		session.setAttribute("split", false);

		RequestDispatcher rd = request.getRequestDispatcher("mainMenu.jsp");
		rd.forward(request, response);

	}

}
