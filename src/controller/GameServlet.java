package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GameInf;
import model.GameManager;
import model.SetGameData;
import model.User;

@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = -359485711102746206L;

	private GameManager gm = new GameManager();
	private SetGameData sgd = new SetGameData();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		GameInf gi = (GameInf) session.getAttribute("gameInf");
		int command = Integer.parseInt(request.getParameter("command"));

		gi = gm.GameManagement(gi, command);

		if (gi.getPlayer().getHandList().size() == 1) {
			session.setAttribute("message", gi.getPlayer().getResult(0));
		} else {
			session.setAttribute("message", gi.getPlayer().getResult(0));
			session.setAttribute("message2", gi.getPlayer().getResult(1));
		}

		user = sgd.setData(user, gi.getPlayer());
		session.setAttribute("user", user);
		session.setAttribute("gameInf", gi);

		RequestDispatcher rd = request.getRequestDispatcher("mainMenu.jsp");
		rd.forward(request, response);

	}

}
