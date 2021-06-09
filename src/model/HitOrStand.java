package model;

public class HitOrStand {

	Player player;
	Dealer dealer;
	Deck deckInf;

	public GameInf doHit(GameInf gi) {

		player = gi.getPlayer();
		dealer = gi.getDealer();
		deckInf = gi.getDeck();
		int chip = gi.getChip();

		deckInf = player.draw(deckInf);

		if (player.getBust()) {
			gi = new GameInf(player, dealer, deckInf, -chip, "Lose");
		} else {
			gi = new GameInf(player, dealer, deckInf, chip, null);
		}

		return gi;
	}

	public GameInf doStand(GameInf gi) {

		player = gi.getPlayer();
		dealer = gi.getDealer();
		deckInf = gi.getDeck();
		int chip = gi.getChip();

		deckInf = dealer.draw(deckInf);

		if (dealer.getBust()) {
			gi = new GameInf(player, dealer, deckInf, chip, "Win");
		} else {

			player.changeAscore();
			dealer.changeAscore();

			if (player.getScore() > dealer.getScore()) {
				gi = new GameInf(player, dealer, deckInf, chip, "Win");
			} else if (player.getScore() == dealer.getScore()) {
				gi = new GameInf(player, dealer, deckInf, 0, "Draw");
			} else if (player.getScore() < dealer.getScore()) {
				gi = new GameInf(player, dealer, deckInf, -chip, "Lose");
			}

		}

		return gi;
	}

}
