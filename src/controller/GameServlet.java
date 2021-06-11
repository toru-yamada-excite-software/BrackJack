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
import model.WinLoseConvert;

@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = -359485711102746206L;

	private GameManager gm = new GameManager();
	private SetGameData sgd = new SetGameData();
	private WinLoseConvert wlc = new WinLoseConvert();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		GameInf gi = (GameInf) session.getAttribute("gameInf");
		int command = Integer.parseInt(request.getParameter("command"));
		int chip = (int) session.getAttribute("chip");

		gi = gm.GameManagement(gi, command, chip);
		String message = wlc.numConvert(gi.getChip());

		user = sgd.setData(user, gi.getChip());

		session.setAttribute("user", user);
		session.setAttribute("gameInf", gi);
		session.setAttribute("message", message);

		RequestDispatcher rd = request.getRequestDispatcher("mainMenu.jsp");
		rd.forward(request, response);

	}

}
