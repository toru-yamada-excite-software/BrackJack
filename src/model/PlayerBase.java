package model;

import java.util.ArrayList;

public abstract class PlayerBase {

	public ArrayList<Card> hand = new ArrayList<Card>();
	protected int score = 0;
	protected int Ascore = 0;
	private boolean bust = false;

	public abstract Deck draw(Deck deckInf);

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
			Ascore = 0;
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

	public ArrayList<Card> getHand() {
		return hand;
	}

}
