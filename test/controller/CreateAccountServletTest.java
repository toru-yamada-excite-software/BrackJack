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
import model.CreateAccountCheck;
import model.User;

public class CreateAccountServletTest {

	@InjectMocks
	private CreateAccountServlet cas = new CreateAccountServlet();

	@Mock
	private UserDB udb;

	@Mock
	private CreateAccountCheck cac;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	//アカウント削除
	@Test
	public void doGetTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		HttpSession session = request.getSession();
		User user = new User();
		user.setId("1");
		session.setAttribute("user", user);

		doNothing().when(udb).deleteUser("1");

		try {
			cas.doGet(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String expectedMessage = "退会しました";

		String actualMessage = (String) request.getAttribute("message");
		User actualUser = (User) session.getAttribute("user");

		assertEquals(expectedMessage, actualMessage);
		assertNull(actualUser);

	}

	//アカウント作成成功
	@Test
	public void createSuccessTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		String id = "1";
		String password = "p";
		String name = "nn";

		request.setParameter("id", id);
		request.setParameter("password1", password);
		request.setParameter("password2", password);
		request.setParameter("name", name);

		User user = new User();
		user.setId(id);
		user.setPassword(password);
		user.setName(name);

		doReturn(true).when(cac).check(id, password, password, name);
		doNothing().when(udb).insertUser(user);

		try {
			cas.doPost(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String expected = "アカウントを作成しました";
		String actual = (String) request.getAttribute("message");

		assertEquals(expected, actual);

	}

	//アカウント作成失敗
	@Test
	public void createFalseTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		String id = "1";
		String password1 = "p";
		String password2 = "l";
		String name = "nn";

		request.setParameter("id", id);
		request.setParameter("password1", password1);
		request.setParameter("password2", password2);
		request.setParameter("name", name);

		doReturn(false).when(cac).check(id, password1, password2, name);

		try {
			cas.doPost(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String expected = "アカウントを作成できませんでした";
		String actual = (String) request.getAttribute("message");

		assertEquals(expected, actual);

	}

}
