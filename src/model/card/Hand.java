package model.card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hand implements Serializable {
	private static final long serialVersionUID = -7313710987059551688L;

	private List<Card> cards = new ArrayList<>();
	private static final int ACE_ADD_SCORE = 10;
	private static final int BLACKJACK = 21;

	public List<Card> getCards() {
		return cards;
	}

	public void draw(Deck deck) {
		cards.add(deck.poll());
	}

	public boolean canSplit() {
		return cards.size() == 2 && cards.get(0).getCardScore() == cards.get(1).getCardScore();
	}

	public boolean hasAce() {
		return getCards().stream().anyMatch(Card::isAce);
	}

	public int getMinScore() {
		return getCards().stream().mapToInt(Card::getCardScore).sum();
	}

	public int getMaxScore() {
		int score = getMinScore();
		return score <= BLACKJACK - ACE_ADD_SCORE && hasAce() ? score + ACE_ADD_SCORE : score;
	}

	public boolean isBlackjack() {
		return getMaxScore() == BLACKJACK;
	}

	public boolean isBust() {
		return getMaxScore() > BLACKJACK;
	}

	public Hand split() {
		Hand newHand = new Hand();
		Card ret = cards.get(0);
		cards.remove(0);
		newHand.cards.add(ret);
		return newHand;
	}
}