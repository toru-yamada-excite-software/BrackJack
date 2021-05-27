package model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DealerTest {

	private Deck decks;
	private Dealer dealer;
	private ArrayList<Card> deck = new ArrayList<Card>();

	@BeforeEach
	public void setup() {

		decks = new Deck();
		dealer = new Dealer();

		for (int i = 0; i < 4; i++) {

			for (int j = 1; j < 14; j++) {
				Card card = new Card(i, j);
				deck.add(card);
			}

		}

		decks.setDeck(deck);
		decks = dealer.draw(decks);

	}

	@Test
	public void drawTest() {

		int expectedSuite = 0;
		int expectedNumber = 6;

		int actualSuite = dealer.getHand().get(5).getSuite();
		int actualNumber = dealer.getHand().get(5).getNumber();

		assertThat(actualSuite, is(expectedSuite));
		assertThat(actualNumber, is(expectedNumber));

	}

	@Test
	public void scoreCalcTest() {

		int expected = 21;

		int actual = dealer.getScore();

		assertThat(actual, is(expected));

	}

	@Test
	public void bustJudgeTest() {

		dealer.bustJudge();

		boolean expected = false;

		boolean actual = dealer.getBust();

		assertThat(actual, is(expected));

	}

}
