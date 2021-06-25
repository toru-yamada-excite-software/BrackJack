package model;

import java.io.Serializable;

public class Dealer implements Serializable {
	private static final long serialVersionUID = 3272354239289678846L;

	private Hand hand = new Hand();

	public void draw(Deck deck) {

		while (getHighScore() < 17) {
			hand.drawBase(deck);
		}

	}

	public void firstDraw(Deck deck) {

		for (int i = 0; i < 2; i++) {
			hand.drawBase(deck);
		}

	}

	public Hand getHand() {
		return hand;
	}

	public boolean getBust() {
		return hand.getBust();
	}

	public int getHighScore() {
		return hand.getHighScore();
	}

}
