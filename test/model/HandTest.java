package model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HandTest {

	private Deck decks;
	private Hand hand;
	private LinkedList<Card> deck = new LinkedList<Card>();

	@BeforeEach
	private void setup() {

		decks = new Deck();
		hand = new Hand();

		for (int i = 0; i < 4; i++) {

			for (int j = 1; j < 14; j++) {
				Card card = new Card(i, j);
				deck.add(card);
			}

		}

	}

	//scoreCalcテスト
	@Test
	public void scoreCalcTest() {

		decks.setDeck(deck);
		hand.drawBase(decks);

		int expectedScore = 1;
		int expectedAscore = 11;

		int actualScore = hand.getScore();
		int actualAscore = hand.getAscore();

		assertThat(actualScore, is(expectedScore));
		assertThat(actualAscore, is(expectedAscore));

	}

	//drawBaseテスト
	@Test
	public void drawBaseTest() {

		decks.setDeck(deck);
		hand.drawBase(decks);

		String expectedSuite = "♠";
		int expectedNumber = 1;

		String actualSuite = hand.getHand().get(0).getSuite();
		int actualNumber = hand.getHand().get(0).getNumber();

		assertThat(actualSuite, is(expectedSuite));
		assertThat(actualNumber, is(expectedNumber));

	}

	//bustJudgeテスト
	@Test
	public void bustJudgeTest() {

		decks.setDeck(deck);
		for (int i = 0; i < 7; i++) {
			hand.drawBase(decks);
		}

		hand.bustJudge();

		boolean expected = true;

		boolean actual = hand.getBust();

		assertThat(actual, is(expected));

	}

	//changeAscoreテスト
	@Test
	public void changeAscoreTest() {

		decks.setDeck(deck);
		hand.drawBase(decks);

		hand.changeAscore();

		int expectedScore = 11;
		int expectedAscore = 0;

		int actualScore = hand.getScore();
		int actualAscore = hand.getAscore();

		assertThat(actualScore, is(expectedScore));
		assertThat(actualAscore, is(expectedAscore));

	}

}
