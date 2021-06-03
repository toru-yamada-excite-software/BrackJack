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

import dbmodel.UserDB;
import model.User;

@WebServlet("/RankingServlet")
public class RankingServlet extends HttpServlet {
	private static final long serialVersionUID = 5947824596754570018L;

	private UserDB udb = new UserDB();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		ArrayList<User> ranking = udb.getRanking();
		int myRank = udb.getMyRanking(user.getId());

		request.setAttribute("ranking", ranking);
		request.setAttribute("myRank", myRank);

		RequestDispatcher rd = request.getRequestDispatcher("ranking.jsp");
		rd.forward(request, response);

	}

}
