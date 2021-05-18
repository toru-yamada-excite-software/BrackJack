package controller;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import dbmodel.UserDB;
import model.User;

public class LoginServletTest {

	private LoginServlet login;
	private UserDB udb;

	@BeforeEach
	public void name() {
		login = new LoginServlet();
		udb = new UserDB();
	}

	@Test
	public void doGetTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		HttpSession session = request.getSession();
		User user = udb.getUser("1", "p");
		session.setAttribute("user", user);

		try {
			login.doGet(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(nullValue(), session.getAttribute("user"));
		assertEquals("ログアウトしました", request.getAttribute("message"));

	}

	@Test
	public void doPostLogin() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.setAttribute("id", "2");
		request.setAttribute("password", "p");

		try {
			login.doPost(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals("ログインできませんでした", request.getAttribute("message"));

	}

}
