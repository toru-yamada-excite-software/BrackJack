package model;

public class Card {

	//0:スペード、1:クラブ、2:ダイヤ、3:ハート
	private int suite;
	private int number;

	public Card(int suite, int number) {

		this.suite = suite;
		this.number = number;

	}

	public enum Suite {

		SPADE("スペード", 0), CLUB("クラブ", 1), DIAMOID("ダイヤ", 2), HEART("ハート", 3);

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

			for (Suite flt : Suite.values()) { //拡張for文による走査
				if (flt.getId() == id) {
					return flt; //条件に一致するインスタンスを返す
				}
			}
			return null;
		}
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setSuite(int suite) {
		this.suite = suite;
	}

	public String getSuite() {
		Suite flt = Suite.getById(suite);
		return flt.getLabel();
	}
}
