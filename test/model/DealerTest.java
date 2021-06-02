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

	}

	@Test
	public void drawTest() {

		decks.setDeck(deck);
		decks = dealer.draw(decks);

		String expectedSuite = "♠";
		int expectedNumber = 6;

		String actualSuite = dealer.getHand().get(5).getSuite();
		int actualNumber = dealer.getHand().get(5).getNumber();

		assertThat(actualSuite, is(expectedSuite));
		assertThat(actualNumber, is(expectedNumber));

	}

	@Test
	public void firstDrawTest() {

		decks.setDeck(deck);
		decks = dealer.firstDraw(decks);

		String expectedSuite = "♠";
		int expectedNumber = 1;
		String expectedSuite2 = "♠";
		int expectedNumber2 = 2;

		String actualSuite = dealer.getHand().get(0).getSuite();
		int actualNumber = dealer.getHand().get(0).getNumber();

		String actualSuite2 = dealer.getHand().get(1).getSuite();
		int actualNumber2 = dealer.getHand().get(1).getNumber();

		assertThat(actualSuite, is(expectedSuite));
		assertThat(actualNumber, is(expectedNumber));
		assertThat(actualSuite2, is(expectedSuite2));
		assertThat(actualNumber2, is(expectedNumber2));

	}

	@Test
	public void scoreCalcTest() {

		decks.setDeck(deck);
		decks = dealer.draw(decks);

		int expected = 21;

		int actual = dealer.getScore();

		assertThat(actual, is(expected));

	}

	@Test
	public void bustJudgeTest() {

		decks.setDeck(deck);
		decks = dealer.draw(decks);

		dealer.bustJudge();

		boolean expected = false;

		boolean actual = dealer.getBust();

		assertThat(actual, is(expected));

	}

}
