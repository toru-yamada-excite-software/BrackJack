package controller;

import static org.junit.Assert.*;
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

//@ExtendWith(MockitoExtension.class)
public class LoginServletTest {

	//	private LoginServlet login;

	@InjectMocks
	private LoginServlet login = new LoginServlet();

	@Mock
	private UserDB udb;

	//	@BeforeEach
	//	public void name() {
	//		login = new LoginServlet();
	//		udb = new UserDB();
	//	}

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	//ログアウト、セッション削除
	@Test
	public void doGetTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		HttpSession session = request.getSession();
		User user = new User();
		session.setAttribute("user", user);

		try {
			login.doGet(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String expected = "ログアウトしました";
		String actual = (String) request.getAttribute("message");

		assertNull(session.getAttribute("user"));
		assertEquals(expected, actual);

	}

	//ログイン成功
	@Test
	public void doPostLoginTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		HttpSession session = request.getSession();
		request.setParameter("id", "1");
		request.setParameter("password", "p");
		User user = new User();
		doReturn(user).when(udb).getUser("1", "p");

		try {
			login.doPost(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		User actual = (User) session.getAttribute("user");

		assertEquals(user, actual);

	}

	//ログイン失敗
	@Test
	public void doPostFailTest1() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.setAttribute("id", "2");
		request.setAttribute("password", "p");

		doReturn(null).when(udb).getUser("2", "p");

		try {
			login.doPost(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String expected = "ログインできませんでした";
		String actual = (String) request.getAttribute("message");

		assertEquals(expected, actual);

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
