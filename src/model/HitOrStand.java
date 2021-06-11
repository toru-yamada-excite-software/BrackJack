package model;

public class HitOrStand {

	Player player;
	Dealer dealer;
	Deck deck;

	public GameInf doHit(GameInf gi, int chip) {

		player = gi.getPlayer();
		dealer = gi.getDealer();
		deck = gi.getDeck();

		player.draw(deck);

		if (player.getBust()) {
			gi = new GameInf(player, dealer, deck, -chip);
		} else {
			gi = new GameInf(player, dealer, deck, null);
		}

		return gi;
	}

	public GameInf doStand(GameInf gi, int chip) {

		player = gi.getPlayer();
		dealer = gi.getDealer();
		deck = gi.getDeck();

		dealer.draw(deck);

		if (dealer.getBust()) {
			gi = new GameInf(player, dealer, deck, chip);
		} else {

			player.changeAscore();
			dealer.changeAscore();

			if (player.getScore() > dealer.getScore()) {
				gi = new GameInf(player, dealer, deck, chip);
			} else if (player.getScore() == dealer.getScore()) {
				gi = new GameInf(player, dealer, deck, 0);
			} else if (player.getScore() < dealer.getScore()) {
				gi = new GameInf(player, dealer, deck, -chip);
			}

		}

		return gi;
	}

}
