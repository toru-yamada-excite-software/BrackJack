package model;

public class Dealer {

	private Hand hand = new Hand();

	public void draw(Deck deck) {

		while (hand.getAscore() < 17) {
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

	public int getScore() {
		return hand.getScore();
	}

	public int getAscore() {
		return hand.getAscore();
	}

}
