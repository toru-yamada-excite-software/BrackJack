package model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;

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

		ArrayList<Card> deck = d.createDeck();

		int actualSuite = deck.get(0).getSuite();
		int actualNumber = deck.get(0).getNumber();

		assertThat(actualSuite, not(0));
		assertThat(actualNumber, not(1));

	}

}
