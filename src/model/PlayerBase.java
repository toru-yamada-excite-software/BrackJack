package model;

import java.util.ArrayList;

public class PlayerBase {

	public ArrayList<Card> hand;
	protected int score;
	private boolean bust;

	public void scoreCalc() {

		for (int i = 0; i < hand.size(); i++) {
			int number = hand.get(i).getNumber();

			if (number > 10) {
				number = 10;
			}

			score += number;
		}

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

}
