package model;

import java.io.Serializable;
import java.util.LinkedList;

public class Hand implements Serializable {
	private static final long serialVersionUID = -8769769700554333412L;

	private LinkedList<Card> hand = new LinkedList<Card>();
	private int betChip = 0;
	private int getChip = 0;
	private String result = null;

	public void drawBase(Deck deck) {

		hand.add(deck.getDeck().poll());

	}

	public boolean judgeSplit() {

		if (hand.size() == 2 && comparisonHand()) {
			return true;
		}

		return false;
	}

	public void setHand(Card card) {
		hand.add(card);
	}

	public LinkedList<Card> getHand() {
		return hand;
	}

	public int getScore() {

		int score = 0;

		for (int i = 0; i < hand.size(); i++) {
			score += hand.get(i).getCardScore();
		}

		return score;
	}

	public int getAscore() {

		int Ascore = 0;

		for (int i = 0; i < hand.size(); i++) {
			Ascore += hand.get(i).getAcardScore();
		}

		if (Ascore > 21) {
			Ascore -= 10;
		}

		return Ascore;
	}

	public int getHighScore() {

		int score = getScore();
		int Ascore = getAscore();

		if (Ascore > score) {
			return Ascore;
		}

		return score;
	}

	public boolean getBust() {

		if (getScore() > 21) {
			return true;
		}

		return false;
	}

	public boolean comparisonHand() {

		if (hand.get(0).getCardScore() == hand.get(1).getCardScore()) {
			return true;
		}

		return false;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setChip(Integer betChip) {
		this.betChip = betChip;
	}

	public int getChip() {
		return betChip;
	}

	public void setGetChip(double coefficient) {
		getChip = (int) (betChip * coefficient);
	}

	public int getGetChip() {
		return getChip;
	}

}
