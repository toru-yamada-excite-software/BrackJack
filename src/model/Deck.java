package model;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;

public class Deck implements Serializable {
	private static final long serialVersionUID = 2335764105033826325L;

	private LinkedList<Card> deck = new LinkedList<Card>();

	public Deck() {

		for (int j = 1; j <= 13; j++) {

			for (int i = 0; i < 4; i++) {

				Card card = new Card(i, j);
				deck.add(card);
			}

		}
		Collections.shuffle(deck);
	}

	//	public Deck() {
	//
	//		for (int j = 1; j <= 12; j++) {
	//
	//			for (int i = 0; i < 4; i++) {
	//
	//				Card card = new Card(i, j);
	//				deck.add(card);
	//			}
	//
	//		}
	//		deck.add(new Card(2, 13));
	//		deck.add(new Card(3, 13));
	//		Collections.shuffle(deck);
	//		deck.set(0, new Card(0, 13));
	//		deck.set(1, new Card(1, 13));
	//	}

	public void setDeck(LinkedList<Card> deck) {
		this.deck = deck;
	}

	public LinkedList<Card> getDeck() {
		return deck;
	}

}
