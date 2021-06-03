package model;

public class ChangeAscore {

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
