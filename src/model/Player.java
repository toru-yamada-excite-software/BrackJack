package model;

public class Player extends PlayerBase {
	private static final long serialVersionUID = -1993110647316686215L;

	@Override
	public Deck draw(Deck deckInf) {

		deckInf = drawBase(deckInf);
		bustJudge();

		return deckInf;
	}

	public Deck firstDraw(Deck deckInf) {

		for (int i = 0; i < 2; i++) {
			deckInf = drawBase(deckInf);
		}

		return deckInf;
	}

}