package controller;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

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

	//アカウント作成成功
	@Test
	public void createSuccessTest() throws Exception {

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

		cas.doPost(request, response);

		String expected = "アカウントを作成しました";
		String actual = (String) request.getAttribute("message");

		assertThat(actual, is(expected));

	}

	//アカウント作成失敗
	@Test
	public void createFalseTest() throws Exception {

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

		cas.doPost(request, response);

		String expected = "アカウントを作成できませんでした";
		String actual = (String) request.getAttribute("message");

		assertThat(actual, is(expected));

	}

}
