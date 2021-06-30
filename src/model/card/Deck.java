package model.card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck implements Serializable {
	private static final long serialVersionUID = 2335764105033826325L;

	private LinkedList<Card> deck;

	public Deck() {
		List<Card> deckTemplate = new ArrayList<>(Card.CARD_TYPE_COUNT);
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				deckTemplate.add(new Card(suit, rank));
			}
		}
		Collections.shuffle(deckTemplate);
		deck = new LinkedList<>(deckTemplate);
	}

	public Card poll() {
		return deck.poll();
	}

}
