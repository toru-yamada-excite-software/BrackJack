package controller;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

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
		request.setParameter("id", "1");
		request.setParameter("password", "p");
		User user = new User();

		doReturn(user).when(udb).getUser("1", "p");

		login.doPost(request, response);

		User actual = (User) session.getAttribute("user");

		assertThat(actual, is(user));

	}

	//ログイン失敗
	@Test
	public void doPostFailTest1() throws Exception {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.setAttribute("id", "2");
		request.setAttribute("password", "p");

		doReturn(null).when(udb).getUser("2", "p");

		login.doPost(request, response);

		String expected = "ログインできませんでした";
		String actual = (String) request.getAttribute("message");

		assertThat(actual, is(expected));

	}

	//パスワード不一致
	//	@Test
	//	public void doPostFailTest2() {
	//
	//		MockHttpServletRequest request = new MockHttpServletRequest();
	//		MockHttpServletResponse response = new MockHttpServletResponse();
	//		request.setAttribute("id", "1");
	//		request.setAttribute("password", "d");
	//
	//		doReturn(null).when(udb).getUser("1", "a");
	//
	//		try {
	//			login.doPost(request, response);
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//
	//		String expected = "ログインできませんでした";
	//		String actual = (String) request.getAttribute("message");
	//
	//		assertEquals(expected, actual);
	//
	//	}

}
