package model;

public class HitOrStand {

	Player player;
	Dealer dealer;
	Deck deck;

	public GameInf doHit(GameInf gi) {

		player = gi.getPlayer();
		dealer = gi.getDealer();
		deck = gi.getDeck();
		int chip = gi.getChip();

		player.draw(deck);

		if (player.getBust()) {
			gi = new GameInf(player, dealer, deck, -chip, "Lose");
		} else {
			gi = new GameInf(player, dealer, deck, chip, null);
		}

		return gi;
	}

	public GameInf doStand(GameInf gi) {

		player = gi.getPlayer();
		dealer = gi.getDealer();
		deck = gi.getDeck();
		int chip = gi.getChip();

		dealer.draw(deck);

		if (dealer.getBust()) {
			gi = new GameInf(player, dealer, deck, chip, "Win");
		} else {

			player.changeAscore();
			dealer.changeAscore();

			if (player.getScore() > dealer.getScore()) {
				gi = new GameInf(player, dealer, deck, chip, "Win");
			} else if (player.getScore() == dealer.getScore()) {
				gi = new GameInf(player, dealer, deck, 0, "Draw");
			} else if (player.getScore() < dealer.getScore()) {
				gi = new GameInf(player, dealer, deck, -chip, "Lose");
			}

		}

		return gi;
	}

}
