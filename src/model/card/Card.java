package model.card;

import java.io.Serializable;

public class Card implements Serializable {
	private static final long serialVersionUID = 3314780953415621490L;
	public static final int CARD_TYPE_COUNT = Suit.count() * Rank.count();

	private Suit suit;
	private Rank rank;

	public Card(Suit suite, Rank rank) {
		this.suit = suite;
		this.rank = rank;
	}

	public Rank getRank() {
		return rank;
	}

	public boolean isAce() {
		return rank.isAce();
	}

	public int getCardScore() {
		return rank.getCardScores();
	}

	public String getFaceCard() {
		return rank.getFace();
	}

	public String getSuitMark() {
		return suit.getSuitMark();
	}
}
