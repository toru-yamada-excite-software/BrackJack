package model;

import java.util.ArrayList;

public class Stand {

	public GameInf doStand(GameInf gi) {

		Player player = gi.getPlayer();
		Dealer dealer = gi.getDealer();
		Deck deck = gi.getDeck();
		ArrayList<Hand> handList = player.getHandList();

		dealer.draw(deck);

		for (int i = 0; i < handList.size(); i++) {

			Hand playerHand = handList.get(i);

			if (playerHand.getResult() == null) {
				if (dealer.getBust()) {
					player.calcChip(playerHand.getChip());
					playerHand.setResult("Win");

				} else {

					if (playerHand.getHighScore() > dealer.getHighScore()) {
						player.calcChip(playerHand.getChip());
						playerHand.setResult("Win");
					} else if (playerHand.getHighScore() == dealer.getHighScore()) {
						player.calcChip(0);
						playerHand.setResult("Draw");
					} else if (playerHand.getHighScore() < dealer.getHighScore()) {
						player.calcChip(-playerHand.getChip());
						playerHand.setResult("Lose");
					}
				}
			}

		}

		return gi;
	}

}
