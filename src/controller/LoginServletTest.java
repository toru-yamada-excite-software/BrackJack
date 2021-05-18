package controller;

import static org.junit.Assert.*;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

	//ログアウト、セッション削除
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

		try {
			login.doPost(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String expectedId = "1";
		String expectedPassword = "p";
		String expectedName = "n";
		int expectedPlay = 0;
		int expectedWin = 0;
		int expectedDraw = 0;
		double expectedWinRate = 0;

		User actual = (User) session.getAttribute("user");
		String actualId = actual.getId();
		String actualPassword = actual.getPassword();
		String actualName = actual.getName();
		int actualPlay = actual.getPlay();
		int actualWin = actual.getWin();
		int actualDraw = actual.getDraw();
		double actualWinRate = actual.getWinLate();

		assertEquals(expectedId, actualId);
		assertEquals(expectedPassword, actualPassword);
		assertEquals(expectedName, actualName);
		assertEquals(expectedPlay, actualPlay);
		assertEquals(expectedWin, actualWin);
		assertEquals(expectedDraw, actualDraw);
		assertEquals(expectedWinRate, actualWinRate, 0);

	}

	//ID不一致
	@Test
	public void doPostFailTest1() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.setAttribute("id", "2");
		request.setAttribute("password", "p");

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
	@Test
	public void doPostFailTest2() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.setAttribute("id", "1");
		request.setAttribute("password", "d");

		try {
			login.doPost(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String expected = "ログインできませんでした";
		String actual = (String) request.getAttribute("message");

		assertEquals(expected, actual);

	}

}
