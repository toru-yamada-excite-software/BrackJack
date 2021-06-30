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
import entity.User;

@WebServlet("/UpdateAccountServlet")
public class UpdateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 715640114755191650L;

	private UserDB udb = new UserDB();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		User user = (User) session.getAttribute("user");

		if (name.equals(user.getName()) || !name.equals("")) {
			user.setName(name);
			udb.updateUserName(user);

			request.setAttribute("message", "ニックネームを変更しました");
			session.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("accountmanagement.jsp");
			rd.forward(request, response);
		}

		else {
			request.setAttribute("message", "ニックネームを変更出来ませんでした");
			RequestDispatcher rd = request.getRequestDispatcher("accountmanagement.jsp");
			rd.forward(request, response);
		}

	}

}