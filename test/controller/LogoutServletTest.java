package controller;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import model.User;

public class LogoutServletTest {

	private LogoutServlet logout = new LogoutServlet();

	//ログアウト、セッション削除
	@Test
	public void doPostTest() throws Exception {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		HttpSession session = request.getSession();
		User user = new User();
		session.setAttribute("user", user);

		logout.doPost(request, response);

		String expected = "ログアウトしました";
		String actual = (String) request.getAttribute("message");

		assertNull(session.getAttribute("user"));
		assertThat(actual, is(expected));

	}

}
