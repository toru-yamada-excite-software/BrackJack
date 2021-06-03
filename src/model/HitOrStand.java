package model;

public class HitOrStand {

	private ChangeAscore ca = new ChangeAscore();

	public GameInf doHit(GameInf gi) {

		Player player = gi.getPlayer();
		Dealer dealer = gi.getDealer();
		Deck deckInf = gi.getDeck();

		deckInf = player.draw(deckInf);

		if (player.getBust()) {
			gi = new GameInf(player, dealer, deckInf, "Lose");
		} else {
			gi = new GameInf(player, dealer, deckInf, null);
		}

		return gi;
	}

	public GameInf doStand(GameInf gi) {

		Player player = gi.getPlayer();
		Dealer dealer = gi.getDealer();
		Deck deckInf = gi.getDeck();

		deckInf = dealer.draw(deckInf);

		if (dealer.getBust()) {
			gi = new GameInf(player, dealer, deckInf, "Win");
		} else {

			player = ca.changePlayerAscore(player);
			dealer = ca.changeDealerAscore(dealer);

			if (player.getScore() > dealer.getScore()) {
				gi = new GameInf(player, dealer, deckInf, "Win");
			} else if (player.getScore() == dealer.getScore()) {
				gi = new GameInf(player, dealer, deckInf, "Draw");
			} else if (player.getScore() < dealer.getScore()) {
				gi = new GameInf(player, dealer, deckInf, "Lose");
			}

		}

		return gi;
	}

}
