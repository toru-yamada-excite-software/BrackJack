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

public class UpdateAccountServletTest {

	@InjectMocks
	private UpdateAccountServlet uas = new UpdateAccountServlet();

	@Mock
	private UserDB udb;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void doPostTest() throws Exception {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		HttpSession session = request.getSession();

		String name = "n";
		User user = new User();
		user.setName("nn");
		request.setParameter("name", name);
		session.setAttribute("user", user);

		doNothing().when(udb).updateUserName(user);

		uas.doPost(request, response);

		String expectedMessage = "ニックネームを変更しました";
		String expectedName = "n";
		String actualMessage = (String) request.getAttribute("message");
		user = (User) session.getAttribute("user");
		String actualName = user.getName();

		assertThat(actualMessage, is(expectedMessage));
		assertThat(actualName, is(expectedName));

	}

}
