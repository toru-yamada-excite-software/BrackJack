package model;

import java.util.ArrayList;

public abstract class PlayerBase {

	public ArrayList<Card> hand = new ArrayList<Card>();
	protected int score = 0;
	protected int Ascore = 0;
	private boolean bust = false;

	public abstract Deck draw(Deck deckInf);

	public void scoreCalc() {

		boolean existA = false;

		score = 0; //scoreリセット後再計算
		for (int i = 0; i < hand.size(); i++) {
			int number = hand.get(i).getNumber();

			//11以上は10に
			if (number > 10) {
				number = 10;
			}

			if (number == 1) {
				existA = true;
			}

			score += number;
		}

		if (existA) {

			int j = 0;
			Ascore = 0; //Ascoreリセット後再計算
			for (int i = 0; i < hand.size(); i++) {
				int number = hand.get(i).getNumber();

				//11以上は10に
				if (number > 10) {
					number = 10;
				}

				if (number == 1 && j == 0) {
					number = 11;
					j++;
				}

				Ascore += number;
			}

			if (Ascore > 21) {
				Ascore = 0;
			}

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

	public int getAscore() {
		return Ascore;
	}

	public boolean getBust() {
		return bust;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

}
