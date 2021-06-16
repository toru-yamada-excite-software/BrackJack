package model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

	private Deck decks;
	private Player player;
	private int chip = 100;
	private int index = 0;
	private LinkedList<Card> deck = new LinkedList<Card>();

	@BeforeEach
	public void setup() {

		decks = new Deck();
		player = new Player(chip);

		for (int i = 0; i < 4; i++) {

			for (int j = 1; j < 14; j++) {
				Card card = new Card(i, j);
				deck.add(card);
			}

		}

		decks.setDeck(deck);
		player.draw(decks, index);

	}

	//drawテスト
	@Test
	public void drawTest() {

		String expectedSuite = "♠";
		int expectedNumber = 1;

		String actualSuite = player.getHand(index).getHand().get(0).getSuite();
		int actualNumber = player.getHand(index).getHand().get(0).getNumber();

		assertThat(actualSuite, is(expectedSuite));
		assertThat(actualNumber, is(expectedNumber));

	}

	//fistDrawテスト
	@Test
	public void firstDrawTest() {

		decks.setDeck(deck);
		player.firstDraw(decks);

		String expectedSuite = "♠";
		int expectedNumber = 1;
		String expectedSuite2 = "♠";
		int expectedNumber2 = 2;

		String actualSuite = player.getHand(index).getHand().get(0).getSuite();
		int actualNumber = player.getHand(index).getHand().get(0).getNumber();

		String actualSuite2 = player.getHand(index).getHand().get(1).getSuite();
		int actualNumber2 = player.getHand(index).getHand().get(1).getNumber();

		assertThat(actualSuite, is(expectedSuite));
		assertThat(actualNumber, is(expectedNumber));
		assertThat(actualSuite2, is(expectedSuite2));
		assertThat(actualNumber2, is(expectedNumber2));

	}

	//permitSplitテスト
	@Test
	public void permitSplitTest() {

		player.draw(decks, index);
		player.permitSplit();

		boolean expected = false;

		boolean actual = player.getSplit();

		assertThat(actual, is(expected));

	}

}
