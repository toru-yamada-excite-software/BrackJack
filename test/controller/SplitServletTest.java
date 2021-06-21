package controller;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import model.Card;
import model.Deck;
import model.GameInf;
import model.Hand;
import model.Player;

public class SplitServletTest {

	@InjectMocks
	private SplitServlet ss = new SplitServlet();

	@Mock
	private GameInf gi;

	@Mock
	private Player player;

	private Hand hand;
	private Deck decks;
	private LinkedList<Card> deck = new LinkedList<Card>();

	@Mock
	private ArrayList<Hand> handList;

	@Mock
	private LinkedList<Card> handCard;

	@Mock
	private MockHttpServletRequest request;

	@Mock
	private RequestDispatcher rd;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);

		decks = new Deck();
		hand = new Hand();

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
