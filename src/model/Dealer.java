package model;

public class Dealer extends PlayerBase {
	private static final long serialVersionUID = 2004917337820863277L;

	@Override
	public void draw(Deck deck) {

		while (Ascore < 17) {
			drawBase(deck);
			bustJudge();
		}

	}

	public void firstDraw(Deck deck) {

		for (int i = 0; i < 2; i++) {
			drawBase(deck);
		}

	}

}
