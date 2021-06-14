package model;

public class HitOrStand {

	Player player;
	Dealer dealer;
	Deck deck;

	public GameInf doHit(GameInf gi, int betChip, int command) {

		player = gi.getPlayer();
		dealer = gi.getDealer();
		deck = gi.getDeck();

		player.draw(deck, command);

		if (player.getBust(command)) {
			player.setChip(-betChip, command);
			gi = new GameInf(player, dealer, deck);
		} else {
			gi = new GameInf(player, dealer, deck);
		}

		return gi;
	}

	public GameInf doStand(GameInf gi, int betChip) {

		player = gi.getPlayer();
		dealer = gi.getDealer();
		deck = gi.getDeck();

		dealer.draw(deck);

		if (dealer.getBust()) {
			if (player.getHandList().size() != 1) {
				player.setChip(betChip, 0);
				gi = new GameInf(player, dealer, deck);
			} else {
				player.setChip(betChip, 0);
				player.setChip(betChip, 1);
				gi = new GameInf(player, dealer, deck);
			}
		} else {

			player.getHand(0).changeAscore();
			dealer.getHand().changeAscore();

			if (!player.getBust(0)) {
				if (player.getScore(0) > dealer.getScore()) {
					player.setChip(betChip, 0);
					gi = new GameInf(player, dealer, deck);
				} else if (player.getScore(0) == dealer.getScore()) {
					player.setChip(0, 0);
					gi = new GameInf(player, dealer, deck);
				} else if (player.getScore(0) < dealer.getScore()) {
					player.setChip(-betChip, 0);
					gi = new GameInf(player, dealer, deck);
				}
			}

			if (player.getHandList().size() == 2 && !player.getBust(1)) {
				player.getHand(1).changeAscore();

				if (player.getScore(1) > dealer.getScore()) {
					player.setChip(betChip, 1);
					gi = new GameInf(player, dealer, deck);
				} else if (player.getScore(1) == dealer.getScore()) {
					player.setChip(0, 1);
					gi = new GameInf(player, dealer, deck);
				} else if (player.getScore(1) < dealer.getScore()) {
					player.setChip(-betChip, 1);
					gi = new GameInf(player, dealer, deck);
				}

			}
		}

		return gi;
	}

}
