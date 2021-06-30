package model.actor;

import java.io.Serializable;
import java.util.stream.IntStream;

import model.card.Deck;
import model.card.Hand;

public class Dealer implements Serializable {
	private static final long serialVersionUID = 3272354239289678846L;

	private static final int MINIMUM_SCORE = 17;

	private Hand hand = new Hand();

	public Dealer(Deck deck) {
		IntStream.range(0, 2).forEach(i -> hand.draw(deck));
	}

	public void draw(Deck deck) {
		while (hand.getMaxScore() < MINIMUM_SCORE) {
			hand.draw(deck);
		}
	}

	public Hand getHand() {
		return hand;
	}
}
