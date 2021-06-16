package controller;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Matchers.*;
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
import model.Player;
import model.SetGameData;
import model.User;

public class GameServletTest {

	@InjectMocks
	private GameServlet gs = new GameServlet();

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
		Player player = new Player(0);
		GameInf gi = new GameInf(player, null, null);
		request.setParameter("command", "0");
		session.setAttribute("user", user);
		session.setAttribute("gameInf", gi);

		doReturn(gi).when(gm).GameManagement(anyObject(), anyInt());
		doReturn(user).when(sgd).setData(anyObject(), anyObject());

		gs.doPost(request, response);

		String expectedId = "id";
		session = request.getSession();
		User actualUser = (User) session.getAttribute("user");
		String actualId = actualUser.getId();

		assertThat(actualId, is(expectedId));

	}

}
