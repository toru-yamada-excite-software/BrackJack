package model;

import java.io.Serializable;

public class Card implements Serializable {
	private static final long serialVersionUID = 3314780953415621490L;

	//0:スペード、1:クラブ、2:ダイヤ、3:ハート
	private int suite;
	private int number;

	public Card(int suite, int number) {

		this.suite = suite;
		this.number = number;

	}

	public enum Suite {

		SPADE("♠", 0), CLUB("♣", 1), DIAMOND("♢", 2), HEART("♡", 3);

		private String label;
		private int id;

		private Suite(String label, int id) {
			this.label = label;
			this.id = id;
		}

		public String getLabel() {
			return label;
		}

		public int getId() {
			return id;
		}

		public static Suite getById(int id) {

			for (Suite flt : Suite.values()) {
				if (flt.getId() == id) {
					return flt;
				}
			}
			return null;
		}
	}

	public int getNumber() {
		return number;
	}

	public String getSuite() {
		Suite flt = Suite.getById(suite);
		return flt.getLabel();
	}
}
