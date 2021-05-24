package controller;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
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

public class DeleteAccountServletTest {

	@InjectMocks
	private DeleteAccountServlet cas = new DeleteAccountServlet();

	@Mock
	private UserDB udb;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	//アカウント削除
	@Test
	public void doGetTest() throws Exception {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		HttpSession session = request.getSession();
		User user = new User();
		user.setId("1");
		session.setAttribute("user", user);

		doNothing().when(udb).deleteUser("1");

		cas.doPost(request, response);

		String expectedMessage = "退会しました";

		String actualMessage = (String) request.getAttribute("message");
		User actualUser = (User) session.getAttribute("user");

		assertThat(actualMessage, is(expectedMessage));
		assertNull(actualUser);

	}

}
