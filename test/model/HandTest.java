package model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.lang.reflect.Method;
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

		decks.setDeck(deck);
	}

	//scoreCalcテスト
	@Test
	public void scoreCalcTest() {

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
	public void bustJudgeTest() throws Exception {

		for (int i = 0; i < 7; i++) {
			hand.drawBase(decks);
		}

		Method method = Hand.class.getDeclaredMethod("bustJudge");
		method.setAccessible(true);
		method.invoke(hand);

		boolean expected = true;

		boolean actual = hand.getBust();

		assertThat(actual, is(expected));

	}

	//judgeSplitテスト
	@Test
	public void judgeSplitTestFalse() {

		hand.drawBase(decks);
		hand.drawBase(decks);

		boolean expected = false;

		boolean actual = hand.judgeSplit();

		assertThat(actual, is(expected));

	}

	@Test
	public void judgeSplitTestTrue() {

		hand.drawBase(decks);
		for (int i = 0; i < 12; i++) {
			decks.getDeck().poll();
		}
		hand.drawBase(decks);

		boolean expected = true;

		boolean actual = hand.judgeSplit();

		assertThat(actual, is(expected));

	}

	@Test
	public void judgeSplitTestTrue10heigher() {

		for (int i = 0; i < 10; i++) {
			decks.getDeck().poll();
		}
		hand.drawBase(decks);
		hand.drawBase(decks);

		boolean expected = true;

		boolean actual = hand.judgeSplit();

		assertThat(actual, is(expected));

	}

	//changeAscoreテスト
	@Test
	public void changeAscoreTest() {

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
