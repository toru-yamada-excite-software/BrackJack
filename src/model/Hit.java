package model;

import java.util.ArrayList;

public class Hit {

	public GameInf doHit(GameInf gi, int index) {

		Player player = gi.getPlayer();
		Deck deck = gi.getDeck();
		ArrayList<Hand> handList = player.getHandList();
		EndProcess ep = new EndProcess();

		player.draw(deck, index);

		if (handList.get(index).getBust()) {
			ep.setResult(handList.get(index), Result.getByResult("Lose"));
		}

		return gi;
	}

}
