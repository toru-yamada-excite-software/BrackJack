package controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import dbmodel.GameDB;
import model.Game;
import model.User;

public class GameLogServletTest {

	@InjectMocks
	private GameLogServlet gls = new GameLogServlet();

	@Mock
	private GameDB gdb;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void doGetTest() {

		int id = 1;
		String userId = "id";
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		HttpSession session = request.getSession();
		User user = new User();
		user.setId(userId);
		session.setAttribute("user", user);
		Game game = new Game();
		game.setId(id);
		game.setUserId(userId);

		ArrayList<Game> gameList = new ArrayList<Game>();
		gameList.add(game);

		doReturn(gameList).when(gdb).getGame(userId);

		try {
			gls.doGet(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ArrayList<Game> getList = (ArrayList<Game>) request.getAttribute("gameList");

		String expected = userId;
		String actual = getList.get(0).getUserId();

		assertEquals(expected, actual);

	}

}
