package model.actor;

import java.io.Serializable;
import java.util.List;

import model.card.Card;
import model.card.Deck;
import model.card.Hand;

public class BettingBox implements Serializable {
	private static final long serialVersionUID = -405517283528226537L;

	static final int ACE_ADD_SCORE = 10;
	static final int BLACKJACK = 21;

	private Hand hand = new Hand();
	private BetChip chip;

	public BettingBox(int betChip) {
		chip = new BetChip(betChip);
	}

	public Hand getHand() {
		return hand;
	}

	public void draw(Deck deck) {
		hand.draw(deck);
		if (hand.isBust()) {
			chip.setResult(Result.LOSE);
		}
	}

	public boolean canSplit() {
		return hand.canSplit();
	}

	public BettingBox split() {
		BettingBox newBox = new BettingBox(chip.getChip());
		newBox.hand = hand.split();
		return newBox;
	}

	public boolean hasAce() {
		return hand.hasAce();
	}

	public List<Card> getCards() {
		return hand.getCards();
	}

	public int getChip() {
		return chip.getChip();
	}

	public Result getResult() {
		return chip.getResult();
	}

	public int getWinChip() {
		return chip.getWinChip();
	}

	public boolean isEnd() {
		return chip.getResult() != null;
	}

	public void setResultNaturalBlackjack(Hand dealerHand) {
		if (isEnd()) {
			return;
		}
		chip.setResult(judgeNaturalBlackjack(dealerHand));
	}

	private Result judgeNaturalBlackjack(Hand dealerHand) {
		if (hand.isBlackjack()) {
			return dealerHand.isBlackjack() ? Result.DRAW : Result.NB_WIN;
		}
		return dealerHand.isBlackjack() ? Result.LOSE : null;
	}

	public void setResultWinOrLose(Hand dealerHand) {
		if (isEnd()) {
			return;
		}
		chip.setResult(judgeWinOrLose(dealerHand));
	}

	private Result judgeWinOrLose(Hand dealerHand) {
		int diff = hand.getMaxScore() - dealerHand.getMaxScore();
		return dealerHand.isBust() || diff > 0 ? Result.WIN : diff == 0 ? Result.DRAW : Result.LOSE;
	}
}
