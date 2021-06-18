package model;

import java.util.ArrayList;

public class Hit {

	public GameInf doHit(GameInf gi, int command) {

		Player player = gi.getPlayer();
		Dealer dealer = gi.getDealer();
		Deck deck = gi.getDeck();
		ArrayList<Hand> handList = player.getHandList();

		player.draw(deck, command);

		if (handList.get(command).getBust()) {
			player.calcChip(-handList.get(command).getChip());
			handList.get(command).setResult("Lose");
			gi = new GameInf(player, dealer, deck);
		} else {
			gi = new GameInf(player, dealer, deck);
		}

		return gi;
	}

}
