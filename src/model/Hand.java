package model;

import java.util.LinkedList;

public class Hand {

	private LinkedList<Card> hand = new LinkedList<Card>();
	private Integer chip = null;
	private int score = 0;
	private int Ascore = 0;
	private boolean bust = false;

	public void scoreCalc() {

		int j = 0;
		score = 0; //scoreリセット後再計算
		Ascore = 0;
		for (int i = 0; i < hand.size(); i++) {
			int number = hand.get(i).getNumber();

			//11以上は10に
			if (number > 10) {
				number = 10;
			}

			Ascore += number;

			if (number == 1 && j == 0) {
				Ascore += 10;
				j++;
			}

			score += number;
		}

		if (score == Ascore || Ascore > 21) {
			Ascore = score;
		}

		//score計算後bust判定
		bustJudge();

	}

	public void drawBase(Deck deck) {

		hand.add(deck.getDeck().poll());
		scoreCalc();

	}

	public void setHand(Card card) {
		hand.add(card);
	}

	public LinkedList<Card> getHand() {
		return hand;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setAscore(int Ascore) {
		this.Ascore = Ascore;
	}

	public int getAscore() {
		return Ascore;
	}

	public boolean getBust() {
		return bust;
	}

	public void setChip(Integer betChip) {
		this.chip = betChip;
	}

	public Integer getChip() {
		return chip;
	}

	public void bustJudge() {

		if (score > 21) {
			bust = true;
		} else {
			bust = false;
		}

	}

	public void changeAscore() {

		if (Ascore > score) {
			score = Ascore;
			Ascore = 0;
		}

	}

}
