package model;

import java.util.ArrayList;

public class Player extends PlayerBase {

	@Override
	public Deck draw(Deck deckInf) {

		ArrayList<Card> deck = deckInf.getDeck();
		int index = deckInf.getIndex();
		Card card = deck.get(index);
		super.hand.add(card);
		scoreCalc();
		bustJudge();
		deckInf.setIndex(index + 1);

		return deckInf;
	}

	public Deck firstDraw(Deck deckInf) {

		ArrayList<Card> deck = deckInf.getDeck();

		for (int i = 0; i < 2; i++) {

			int index = deckInf.getIndex();
			Card card = deck.get(index);
			super.hand.add(card);
			scoreCalc();
			deckInf.setIndex(index + 1);

		}

		return deckInf;
	}

}