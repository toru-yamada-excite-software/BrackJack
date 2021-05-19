package controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import dbmodel.UserDB;
import model.User;

@ExtendWith(value = { MockitoExtension.class })
public class AccountServletTest {

	@InjectMocks
	private ControlAccountServlet cas = new ControlAccountServlet();

	@Mock
	private UserDB udb;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void doGetTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		HttpSession session = request.getSession();

		doNothing().when(udb).getUser("1");

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

	//	public void createSuccessTest() {
	//
	//	}
	//
	//	public void createFalseTest() {
	//
	//	}

}
