package model;

public class Player extends PlayerBase {
	private static final long serialVersionUID = -1993110647316686215L;

	@Override
	public void draw(Deck deck) {

		drawBase(deck);
		bustJudge();

	}

	public void firstDraw(Deck deck) {

		for (int i = 0; i < 2; i++) {
			drawBase(deck);
		}

	}

}