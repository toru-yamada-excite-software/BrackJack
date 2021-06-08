package controller;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import dbmodel.UserDB;
import model.User;

public class LoginServletTest {

	@InjectMocks
	private LoginServlet login = new LoginServlet();

	@Mock
	private UserDB udb;

	@Mock
	private MockHttpServletRequest request;

	@Mock
	private RequestDispatcher rd;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	//ログイン成功
	@Test
	public void doPostLoginTest() throws Exception {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		HttpSession session = request.getSession();
		User user = new User();

		doReturn("1").when(this.request).getParameter("id");
		doReturn("p").when(this.request).getParameter("password");
		doReturn(session).when(this.request).getSession();
		doReturn(user).when(udb).getUser("1", "p");
		doReturn(rd).when(this.request).getRequestDispatcher("menu.jsp");
		doNothing().when(rd).forward(anyObject(), anyObject());

		login.doPost(this.request, response);

		session = request.getSession();
		User actual = (User) session.getAttribute("user");

		verify(this.request, times(1)).getRequestDispatcher("menu.jsp");
		assertThat(actual, is(user));

	}

	//ログイン失敗
	@Test
	public void doPostFailTest1() throws Exception {

		MockHttpServletResponse response = new MockHttpServletResponse();

		doReturn("2").when(request).getParameter("id");
		doReturn("p").when(request).getParameter("password");
		doReturn(null).when(udb).getUser("2", "p");
		doReturn(rd).when(request).getRequestDispatcher("login.jsp");
		doNothing().when(rd).forward(anyObject(), anyObject());

		login.doPost(this.request, response);

		verify(this.request, times(1)).setAttribute("message", "ログインできませんでした");
		verify(this.request, times(1)).getRequestDispatcher("login.jsp");

	}

}
