package model;

import java.util.ArrayList;

public class Dealer extends PlayerBase {

	public Deck draw(Deck decks) {

		ArrayList<Card> deck = decks.getDeck();

		while (score < 17) {

			int index = decks.getIndex();
			Card card = deck.get(index);
			super.hand.add(card);
			scoreCalc();
			decks.setIndex(index + 1);

		}

		return decks;
	}

}
