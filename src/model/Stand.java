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

			Hand hand = handList.get(i);

			if (hand.getResult() == null) {
				if (dealer.getBust()) {
					player.calcChip(hand.getChip());
					hand.setResult("Win");
					gi = new GameInf(player, dealer, deck);
				} else {
					hand.changeAscore();
					dealer.getHand().changeAscore();
					if (hand.getScore() > dealer.getScore()) {
						player.calcChip(hand.getChip());
						hand.setResult("Win");
						gi = new GameInf(player, dealer, deck);
					} else if (hand.getScore() == dealer.getScore()) {
						player.calcChip(0);
						hand.setResult("Draw");
						gi = new GameInf(player, dealer, deck);
					} else if (hand.getScore() < dealer.getScore()) {
						player.calcChip(-hand.getChip());
						hand.setResult("Lose");
						gi = new GameInf(player, dealer, deck);
					}
				}
			}

		}

		return gi;
	}

}
