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
import model.CreateAccountCheck;
import model.User;

@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 6364871625137530566L;

	UserDB udb = new UserDB();
	CreateAccountCheck cac = new CreateAccountCheck();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String id = user.getId();

		udb.deleteUser(id);

		request.setAttribute("message", "退会しました");
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String name = request.getParameter("name");

		//アカウント作成可能か判定
		if (cac.check(id, password1, password2, name)) {

			User user = new User();
			user.setId(id);
			user.setPassword(password1);
			user.setName(name);
			udb.insertUser(user);

			request.setAttribute("message", "アカウントを作成しました");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);

		} else {
			request.setAttribute("message", "アカウントを作成できませんでした");
			RequestDispatcher rd = request.getRequestDispatcher("createaccount.jsp");
			rd.forward(request, response);
		}

	}

}
