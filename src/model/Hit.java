package model;

import java.util.ArrayList;

public class Hit {

	public GameInf doHit(GameInf gi, int index) {

		Player player = gi.getPlayer();
		Dealer dealer = gi.getDealer();
		Deck deck = gi.getDeck();
		ArrayList<Hand> handList = player.getHandList();

		player.draw(deck, index);

		if (handList.get(index).getBust()) {
			player.calcChip(-handList.get(index).getChip());
			handList.get(index).setResult("Lose");
			gi = new GameInf(player, dealer, deck);
		} else {
			gi = new GameInf(player, dealer, deck);
		}

		return gi;
	}

}
