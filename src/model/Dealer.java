package model;

import java.util.ArrayList;

public class Dealer extends PlayerBase {
	private static final long serialVersionUID = 2004917337820863277L;

	@Override
	public Deck draw(Deck deckInf) {

		ArrayList<Card> deck = deckInf.getDeck();

		if (Ascore == 0) {

			while (score < 17) {

				int index = deckInf.getIndex();
				Card card = deck.get(index);
				super.hand.add(card);
				scoreCalc();
				bustJudge();
				deckInf.setIndex(index + 1);

			}

		} else {

			while (Ascore < 17 && score < 17) {

				int index = deckInf.getIndex();
				Card card = deck.get(index);
				super.hand.add(card);
				scoreCalc();
				bustJudge();
				deckInf.setIndex(index + 1);

			}

		}

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
