package model;

public class GameManager {

	GameInf gi;
	int command;

	public GameManager(GameInf gi, int command) {
		this.gi = gi;
		this.command = command;
	}

	public GameInf GameManagement() {

		Player player = gi.getPlayer();
		Dealer dealer = gi.getDealer();
		Deck deckInf = gi.getDeck();

		if (command == 0) {

			deckInf = player.draw(deckInf);

			if (player.getBust()) {
				gi = new GameInf(player, dealer, deckInf, "Lose");
				return gi;
			} else {
				gi = new GameInf(player, dealer, deckInf, null);
				return gi;
			}

		} else if (command == 1) {

			deckInf = dealer.draw(deckInf);

			if (dealer.getBust()) {
				gi = new GameInf(player, dealer, deckInf, "Win");
				return gi;
			} else {

				player = changePlayerAscore(player);
				dealer = changeDealerAscore(dealer);

				if (player.getScore() > dealer.getScore()) {
					gi = new GameInf(player, dealer, deckInf, "Win");
					return gi;
				} else if (player.getScore() == dealer.getScore()) {
					gi = new GameInf(player, dealer, deckInf, "Draw");
					return gi;
				} else if (player.getScore() < dealer.getScore()) {
					gi = new GameInf(player, dealer, deckInf, "Lose");
					return gi;
				}

			}
		}

		return null;
	}

	public GameInf naturalBJ() {

		Player player = gi.getPlayer();
		Dealer dealer = gi.getDealer();
		Deck deckInf = gi.getDeck();

		if (dealer.getAscore() == 21 || player.getAscore() == 21) {

			if (dealer.getAscore() == 21 && player.getAscore() == 21) {
				player = changePlayerAscore(player);
				dealer = changeDealerAscore(dealer);
				gi = new GameInf(player, dealer, deckInf, "Draw");
			} else if (dealer.getAscore() == 21) {
				dealer = changeDealerAscore(dealer);
				gi = new GameInf(player, dealer, deckInf, "Lose");
			} else {
				player = changePlayerAscore(player);
				gi = new GameInf(player, dealer, deckInf, "Win");
			}

		}

		return gi;
	}

	public Player changePlayerAscore(Player player) {

		if (player.getAscore() > player.getScore()) {
			player.setScore(player.getAscore());
			player.setAscore(0);
		}

		return player;
	}

	public Dealer changeDealerAscore(Dealer dealer) {

		if (dealer.getAscore() > dealer.getScore()) {
			dealer.setScore(dealer.getAscore());
			dealer.setAscore(0);
		}

		return dealer;
	}

}
