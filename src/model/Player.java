package model;

public class Player extends PlayerBase {
	private static final long serialVersionUID = -1993110647316686215L;

	private boolean split = false;

	@Override
	public void draw(Deck deck) {

		drawBase(deck);
		bustJudge();

	}

	public void firstDraw(Deck deck) {

		for (int i = 0; i < 2; i++) {
			drawBase(deck);
		}

		judgeSplit();
	}

	public void judgeSplit() {

		if (hand.get(0).getNumber() == hand.get(1).getNumber()) {
			split = true;
		}

	}

	public boolean getSplit() {
		return split;
	}

}