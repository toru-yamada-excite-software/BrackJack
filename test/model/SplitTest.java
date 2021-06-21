package model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SplitTest {

	private Player player;
	private Deck decks;
	private LinkedList<Card> deck = new LinkedList<Card>();
	private GameInf gi;
	private Split split;

	@BeforeEach
	public void setup() {

		split = new Split();
		player = new Player(100);
		decks = new Deck();

		for (int j = 1; j <= 13; j++) {

			for (int i = 0; i < 4; i++) {

				Card card = new Card(i, j);
				deck.add(card);
			}

		}

		decks.setDeck(deck);
		player.firstDraw(decks, 1);
		gi = new GameInf(player, null, decks);

	}

	@Test
	public void doSplitTest() {

		gi = split.doSplit(gi);

		int expected = 2;

		int actual = gi.getPlayer().getHandList().size();

		assertThat(actual, is(expected));

	}

}
