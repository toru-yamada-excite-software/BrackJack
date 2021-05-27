package model;

import java.util.ArrayList;

public abstract class PlayerBase {

	public ArrayList<Card> hand = new ArrayList<Card>();
	protected int score = 0;
	private boolean bust = false;

	public abstract Deck draw(Deck decks);

	public void scoreCalc() {

		score = 0; //scoreリセット後再計算
		for (int i = 0; i < hand.size(); i++) {
			int number = hand.get(i).getNumber();

			//11以上は10に
			if (number > 10) {
				number = 10;
			}

			score += number;
		}

		//score計算後bust判定
		bustJudge();

	}

	public void bustJudge() {

		if (score > 21) {
			bust = true;
		} else {
			bust = false;
		}

	}

	public int getScore() {
		return score;
	}

	public boolean getBust() {
		return bust;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

}
