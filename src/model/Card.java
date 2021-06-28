package model;

import java.io.Serializable;

public class Card implements Serializable {
	private static final long serialVersionUID = 3314780953415621490L;

	//0:スペード、1:クラブ、2:ダイヤ、3:ハート
	private Suite suite;
	private Number number;

	public Card(int suite, int number) {
		this.suite = Suite.getBySuiteId(suite);
		this.number = Number.getByNumberId(number);
	}

	public enum Suite {

		SPADE("♠", 0), CLUB("♣", 1), DIAMOND("♢", 2), HEART("♡", 3);

		private String suiteMark;
		private int suiteId;

		private Suite(String label, int suiteId) {
			this.suiteMark = label;
			this.suiteId = suiteId;
		}

		public String getSuiteMark() {
			return suiteMark;
		}

		public int getSuiteId() {
			return suiteId;
		}

		public static Suite getBySuiteId(int suiteId) {

			for (Suite suite : Suite.values()) {
				if (suite.getSuiteId() == suiteId) {
					return suite;
				}
			}

			return null;
		}
	}

	public enum Number {

		ONE(1, "A"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"), EIGHT(8,
				"8"), NINE(9, "9"), TEN(10, "10"), ELEVEN(11, "J"), TWELVE(12, "Q"), THIRTEEN(13, "K");

		private int number;
		private String face;

		private Number(int numberId, String face) {
			this.number = numberId;
			this.face = face;
		}

		public int getNumber() {
			return number;
		}

		public String getFace() {
			return face;
		}

		public static Number getByNumberId(int numberId) {

			for (Number number : Number.values()) {
				if (number.getNumber() == numberId) {
					return number;
				}
			}

			return null;
		}

	}

	public int getNumber() {
		return number.getNumber();
	}

	public int getCardScore() {

		if (number.getNumber() > 10) {
			return 10;
		}

		return number.getNumber();
	}

	public int getAcardScore() {

		if (number.getNumber() == 1) {
			return 11;
		}

		return getCardScore();
	}

	public String getFaceCard() {
		return number.getFace();
	}

	public String getSuite() {
		return suite.getSuiteMark();
	}
}
