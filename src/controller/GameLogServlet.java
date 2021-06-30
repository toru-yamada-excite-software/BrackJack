package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbmodel.GameDB;
import entity.Game;
import entity.User;

@WebServlet("/GameLogServlet")
public class GameLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1896139184869454421L;

	private GameDB gdb = new GameDB();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		ArrayList<Game> gameList = gdb.getGame(user);

		request.setAttribute("gameList", gameList);

		RequestDispatcher rd = request.getRequestDispatcher("gamelog.jsp");
		rd.forward(request, response);

	}

}
