package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbmodel.UserDB;
import model.GameInf;
import model.User;

@WebServlet("")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 5876378905741836199L;

	private UserDB udb = new UserDB();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		//userテーブル検索
		User user = udb.getUser(id, password);

		//ログイン成功
		if (user != null) {
			HttpSession session = request.getSession();
			GameInf gi = new GameInf(null, null, null, 0);
			session.setAttribute("user", user);
			session.setAttribute("gameInf", gi);
			session.setAttribute("message", null);
			session.setAttribute("split", false);
			RequestDispatcher rd = request.getRequestDispatcher("mainMenu.jsp");
			rd.forward(request, response);

			//ログイン失敗
		} else {
			request.setAttribute("message", "ログインできませんでした");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

	}

}
