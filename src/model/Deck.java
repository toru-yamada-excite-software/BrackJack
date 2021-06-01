package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Deck implements Serializable {
	private static final long serialVersionUID = 2335764105033826325L;

	private ArrayList<Card> deck = new ArrayList<Card>();
	private int index = 0;

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void createDeck() {

		for (int i = 0; i < 4; i++) {

			for (int j = 1; j < 14; j++) {
				Card card = new Card(i, j);
				deck.add(card);
			}

		}

		Collections.shuffle(deck);

	}

}
