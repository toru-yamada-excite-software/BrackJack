package model;

public class GameManager {

	int command;

	public GameManager(int command) {
		this.command = command;
	}

	public GameInf GameManagement(GameInf gi) {

		if (command == 0) {

			doHit(gi);
			return gi;

		} else if (command == 1) {

			doStand(gi);
			return gi;
		}

		return null;
	}

	public GameInf naturalBJ(GameInf gi) {

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

	public void doHit(GameInf gi) {

		Player player = gi.getPlayer();
		Dealer dealer = gi.getDealer();
		Deck deckInf = gi.getDeck();

		deckInf = player.draw(deckInf);

		if (player.getBust()) {
			gi = new GameInf(player, dealer, deckInf, "Lose");
		} else {
			gi = new GameInf(player, dealer, deckInf, null);
		}

	}

	public void doStand(GameInf gi) {

		Player player = gi.getPlayer();
		Dealer dealer = gi.getDealer();
		Deck deckInf = gi.getDeck();

		deckInf = dealer.draw(deckInf);

		if (dealer.getBust()) {
			gi = new GameInf(player, dealer, deckInf, "Win");
		} else {

			player = changePlayerAscore(player);
			dealer = changeDealerAscore(dealer);

			if (player.getScore() > dealer.getScore()) {
				gi = new GameInf(player, dealer, deckInf, "Win");
			} else if (player.getScore() == dealer.getScore()) {
				gi = new GameInf(player, dealer, deckInf, "Draw");
			} else if (player.getScore() < dealer.getScore()) {
				gi = new GameInf(player, dealer, deckInf, "Lose");
			}

		}

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
