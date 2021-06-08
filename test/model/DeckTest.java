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

		String actualSuite = deck.get(0).getSuite();
		int actualNumber = deck.get(0).getNumber();

		assertThat(actualSuite, not("♠"));
		assertThat(actualNumber, not(1));

	}

}
