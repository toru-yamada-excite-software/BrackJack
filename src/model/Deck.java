package model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	ArrayList<Card> deck = new ArrayList<Card>();

	public ArrayList<Card> createDeck() {

		for (int i = 0; i < 4; i++) {

			for (int j = 1; j < 14; j++) {
				Card card = new Card(i, j);
				deck.add(card);
			}

		}

		Collections.shuffle(deck);

		return deck;
	}

}
