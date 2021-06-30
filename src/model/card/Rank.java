package model.card;

public enum Rank {

	ACE(1, "A"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"), EIGHT(8,
			"8"), NINE(9, "9"), TEN(10, "10"), JACK(10, "J"), QUEEN(10, "Q"), KING(10, "K");

	private int cardScores;
	private String face;

	private Rank(int cardScores, String face) {
		this.cardScores = cardScores;
		this.face = face;
	}

	public boolean isAce() {
		return this == ACE;
	}

	public int getCardScores() {
		return cardScores;
	}

	public String getFace() {
		return face;
	}

	public static int count() {
		return values().length;
	}
}