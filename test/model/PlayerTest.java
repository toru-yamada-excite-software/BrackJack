package model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

	private Deck decks;
	private Player player;
	private LinkedList<Card> deck = new LinkedList<Card>();

	@BeforeEach
	public void setup() {

		decks = new Deck();
		player = new Player();

		for (int i = 0; i < 4; i++) {

			for (int j = 1; j < 14; j++) {
				Card card = new Card(i, j);
				deck.add(card);
			}

		}

		decks.setDeck(deck);
		decks = player.draw(decks);

	}

	@Test
	public void drawTest() {

		String expectedSuite = "♠";
		int expectedNumber = 1;

		String actualSuite = player.getHand().get(0).getSuite();
		int actualNumber = player.getHand().get(0).getNumber();

		assertThat(actualSuite, is(expectedSuite));
		assertThat(actualNumber, is(expectedNumber));

	}

	@Test
	public void firstDrawTest() {

		decks.setDeck(deck);
		decks = player.firstDraw(decks);

		String expectedSuite = "♠";
		int expectedNumber = 1;
		String expectedSuite2 = "♠";
		int expectedNumber2 = 2;

		String actualSuite = player.getHand().get(0).getSuite();
		int actualNumber = player.getHand().get(0).getNumber();

		String actualSuite2 = player.getHand().get(1).getSuite();
		int actualNumber2 = player.getHand().get(1).getNumber();

		assertThat(actualSuite, is(expectedSuite));
		assertThat(actualNumber, is(expectedNumber));
		assertThat(actualSuite2, is(expectedSuite2));
		assertThat(actualNumber2, is(expectedNumber2));

	}

	@Test
	public void scoreCalcTest() {

		int expected = 1;

		int actual = player.getScore();

		assertThat(actual, is(expected));

	}

	@Test
	public void bustJudgeTest() {

		player.bustJudge();

		boolean expected = false;

		boolean actual = player.getBust();

		assertThat(actual, is(expected));

	}

}
