package model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeckTest {

	private Deck d;

	@BeforeEach
	public void setup() {

		d = new Deck();

	}

	@Test
	public void createDeckTest() {

		LinkedList<Card> deck = d.getDeck();
		boolean[][] cardCheck = new boolean[4][13];

		for (int i = 0; i < 52; i++) {
			Card card = deck.poll();
			if (card.getSuite().equals("♠")) {
				cardCheck[0][card.getNumber() - 1] = true;
			} else if (card.getSuite().equals("♣")) {
				cardCheck[1][card.getNumber() - 1] = true;
			} else if (card.getSuite().equals("♢")) {
				cardCheck[2][card.getNumber() - 1] = true;
			} else {
				cardCheck[3][card.getNumber() - 1] = true;
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				assertThat(cardCheck[i][j], is(true));
			}
		}

	}

}
