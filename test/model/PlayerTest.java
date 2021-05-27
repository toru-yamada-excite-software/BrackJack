package model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

	private Deck decks;
	private Player player;
	private ArrayList<Card> deck = new ArrayList<Card>();

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

		int expectedSuite = 0;
		int expectedNumber = 1;

		int actualSuite = player.getHand().get(0).getSuite();
		int actualNumber = player.getHand().get(0).getNumber();

		assertThat(actualSuite, is(expectedSuite));
		assertThat(actualNumber, is(expectedNumber));

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
