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

@WebServlet("/HitServlet")
public class HitServlet extends HttpServlet {
	private static final long serialVersionUID = -5302452550169259195L;

	private SetGameData sgd = new SetGameData();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		GameInf gi = (GameInf) session.getAttribute("gameInf");
		int index = Integer.parseInt(request.getParameter("index"));

		gi.hit(index);

		user = sgd.setData(user, gi.getPlayer());
		session.setAttribute("user", user);
		session.setAttribute("gameInf", gi);

		RequestDispatcher rd = request.getRequestDispatcher("mainMenu.jsp");
		rd.forward(request, response);

	}

}
