package model;

public class GameManager {

	private HitOrStand hos = new HitOrStand();

	public GameInf GameManagement(GameInf gi, int command) {

		if (command == 0) {
			return hos.doHit(gi);
		} else {
			return hos.doStand(gi);
		}

	}

	public GameInf naturalBJ(GameInf gi) {

		Player player = gi.getPlayer();
		Dealer dealer = gi.getDealer();
		Deck deckInf = gi.getDeck();
		int chip = gi.getChip();

		if (dealer.getAscore() == 21 || player.getAscore() == 21) {

			player.changeAscore();
			dealer.changeAscore();

			if (dealer.getScore() == 21 && player.getScore() == 21) {
				gi = new GameInf(player, dealer, deckInf, 0, "Draw");
			} else if (dealer.getScore() == 21) {
				gi = new GameInf(player, dealer, deckInf, -chip, "Lose");
			} else {
				gi = new GameInf(player, dealer, deckInf, (int) (chip * 1.5), "Win");
			}

		}

		return gi;
	}

}
