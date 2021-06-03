package model;

public class GameManager {

	private HitOrStand hos = new HitOrStand();
	private ChangeAscore ca = new ChangeAscore();

	public GameInf GameManagement(GameInf gi, int command) {

		if (command == 0) {

			return hos.doHit(gi);

		} else if (command == 1) {

			return hos.doStand(gi);
		}

		return null;
	}

	public GameInf naturalBJ(GameInf gi) {

		Player player = gi.getPlayer();
		Dealer dealer = gi.getDealer();
		Deck deckInf = gi.getDeck();

		if (dealer.getAscore() == 21 || player.getAscore() == 21) {

			if (dealer.getAscore() == 21 && player.getAscore() == 21) {
				player = ca.changePlayerAscore(player);
				dealer = ca.changeDealerAscore(dealer);
				gi = new GameInf(player, dealer, deckInf, "Draw");
			} else if (dealer.getAscore() == 21) {
				dealer = ca.changeDealerAscore(dealer);
				gi = new GameInf(player, dealer, deckInf, "Lose");
			} else {
				player = ca.changePlayerAscore(player);
				gi = new GameInf(player, dealer, deckInf, "Win");
			}

		}

		return gi;
	}

}
