package model;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;

public class Deck implements Serializable {
	private static final long serialVersionUID = 2335764105033826325L;

	private LinkedList<Card> deck = new LinkedList<Card>();

	public Deck() {

		for (int i = 0; i < 4; i++) {

			for (int j = 1; j <= 13; j++) {
				Card card = new Card(i, j);
				deck.add(card);
			}

		}
		Collections.shuffle(deck);
	}

	public void setDeck(LinkedList<Card> deck) {
		this.deck = deck;
	}

	public LinkedList<Card> getDeck() {
		return deck;
	}

}
