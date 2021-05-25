package model;

public class Card {

	//0:スペード、1:クラブ、2:ダイヤ、3:ハート
	private int suite;
	private int number;

	public Card(int suite, int number) {

		this.suite = suite;
		this.number = number;

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

	public int getSuite() {
		return suite;
	}
}
