package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GameManager {

	public void GameManagement(HttpServletRequest request) {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Player player = (Player) session.getAttribute("player");
		Dealer dealer = (Dealer) session.getAttribute("dealer");
		Deck deck = (Deck) session.getAttribute("deckInf");
		int command = Integer.parseInt(request.getParameter("command"));

		if (command == 0) {

		}

	}

}
