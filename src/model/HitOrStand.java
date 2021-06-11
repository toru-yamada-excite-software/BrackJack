package model;

public class HitOrStand {

	Player player;
	Player splitPlayer;
	Dealer dealer;
	Deck deck;

	public GameInf doHit(GameInf gi, int betChip) {

		player = gi.getPlayer();
		splitPlayer = gi.getSplitPlayer();
		dealer = gi.getDealer();
		deck = gi.getDeck();
		Integer splitChip = gi.getSplitChip();

		player.draw(deck);

		if (player.getBust()) {
			gi = new GameInf(player, splitPlayer, dealer, deck, -betChip, splitChip);
		} else {
			gi = new GameInf(player, splitPlayer, dealer, deck, null, splitChip);
		}

		return gi;
	}

	public GameInf doHitSplit(GameInf gi, int betChip) {

		player = gi.getPlayer();
		splitPlayer = gi.getSplitPlayer();
		dealer = gi.getDealer();
		deck = gi.getDeck();
		Integer chip = gi.getChip();

		splitPlayer.draw(deck);

		if (splitPlayer.getBust()) {
			gi = new GameInf(player, splitPlayer, dealer, deck, chip, -betChip);
		} else {
			gi = new GameInf(player, splitPlayer, dealer, deck, chip, null);
		}

		return gi;
	}

	public GameInf doStand(GameInf gi, int betChip) {

		player = gi.getPlayer();
		splitPlayer = gi.getSplitPlayer();
		dealer = gi.getDealer();
		deck = gi.getDeck();
		Integer chip = gi.getSplitChip();

		dealer.draw(deck);

		if (dealer.getBust()) {
			if (splitPlayer != null) {
				gi = new GameInf(player, splitPlayer, dealer, deck, betChip, betChip);
			} else {
				gi = new GameInf(player, splitPlayer, dealer, deck, betChip, chip);
			}
		} else {

			player.changeAscore();
			dealer.changeAscore();

			if (!player.getBust()) {
				if (player.getScore() > dealer.getScore()) {
					gi = new GameInf(player, splitPlayer, dealer, deck, betChip, chip);
				} else if (player.getScore() == dealer.getScore()) {
					gi = new GameInf(player, splitPlayer, dealer, deck, 0, chip);
				} else if (player.getScore() < dealer.getScore()) {
					gi = new GameInf(player, splitPlayer, dealer, deck, -betChip, chip);
				}
			}

			if (splitPlayer != null && !splitPlayer.getBust()) {
				splitPlayer.changeAscore();

				if (splitPlayer.getScore() > dealer.getScore()) {
					gi.setSplitChip(betChip);
				} else if (splitPlayer.getScore() == dealer.getScore()) {
					gi.setSplitChip(0);
				} else if (splitPlayer.getScore() < dealer.getScore()) {
					gi.setSplitChip(-betChip);
				}

			}
		}

		return gi;
	}

}
