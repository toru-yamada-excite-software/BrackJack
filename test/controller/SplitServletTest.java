package controller;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.LinkedList;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import model.Card;
import model.Deck;
import model.GameInf;
import model.Player;

public class SplitServletTest {

	private SplitServlet ss;
	private Deck decks;
	private LinkedList<Card> deck = new LinkedList<Card>();

	@BeforeEach
	public void setup() {

		ss = new SplitServlet();
		decks = new Deck();

		for (int j = 1; j < 14; j++) {

			for (int i = 0; i < 4; i++) {

				Card card = new Card(i, j);
				deck.add(card);
			}

		}

		decks.setDeck(deck);

	}

	@Test
	public void doPostTest() throws Exception {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		HttpSession session = request.getSession();
		Player player = new Player(100);
		player.firstDraw(decks, 0);
		GameInf gi = new GameInf(player, null, decks);

		session.setAttribute("gameInf", gi);

		ss.doPost(request, response);

		session = request.getSession();

		boolean expected = false;
		boolean actual = (boolean) session.getAttribute("split");

		assertThat(actual, is(expected));

	}

}
