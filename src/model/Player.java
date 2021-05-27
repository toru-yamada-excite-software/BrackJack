package model;

import java.util.ArrayList;

public class Player extends PlayerBase {

	public Deck draw(Deck decks) {

		ArrayList<Card> deck = decks.getDeck();
		int index = decks.getIndex();
		Card card = deck.get(index);
		super.hand.add(card);
		decks.setIndex(index + 1);

		return decks;
	}

}
