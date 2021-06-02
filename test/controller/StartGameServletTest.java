package controller;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import model.GameInf;
import model.GameManager;
import model.SetGameData;
import model.User;

public class StartGameServletTest {

	@InjectMocks
	private StartGameServlet sgs = new StartGameServlet();

	@Mock
	private GameManager gm;

	@Mock
	private SetGameData sgd;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void doPostTest() throws Exception {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		HttpSession session = request.getSession();
		User user = new User();
		user.setId("id");
		session.setAttribute("user", user);
		GameInf gi = new GameInf(null, null, null, "Win");

		doReturn(gi).when(gm).naturalBJ();
		doReturn(user).when(sgd).setData(anyObject(), any());

		sgs.doPost(request, response);

		String expectedId = "id";
		String expectedMessage = "Win";
		session = request.getSession();
		user = (User) session.getAttribute("user");
		gi = (GameInf) session.getAttribute("gameInf");
		String actualId = user.getId();
		String actualMessage = gi.getMessage();

		assertThat(actualId, is(expectedId));
		assertThat(actualMessage, is(expectedMessage));

	}

}
