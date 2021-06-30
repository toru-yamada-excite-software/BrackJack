package model.card;

public enum Suit {

	SPADE("♠︎"), CLUB("♣︎️"), DIAMOND("♢️"), HEART("♡️");

	private String suitMark;

	private Suit(String label) {
		this.suitMark = label;
	}

	public String getSuitMark() {
		return suitMark;
	}

	public static int count() {
		return values().length;
	}
}