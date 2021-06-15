package model;

public class HitOrStand {

	Player player;
	Dealer dealer;
	Deck deck;

	public GameInf doHit(GameInf gi, int command) {

		player = gi.getPlayer();
		dealer = gi.getDealer();
		deck = gi.getDeck();

		player.draw(deck, command);

		if (player.getBust(command)) {
			player.calcChip(-player.getBetChip(command));
			player.setResult("Lose", command);
			gi = new GameInf(player, dealer, deck);
		} else {
			gi = new GameInf(player, dealer, deck);
		}

		return gi;
	}

	public GameInf doStand(GameInf gi) {

		player = gi.getPlayer();
		dealer = gi.getDealer();
		deck = gi.getDeck();

		dealer.draw(deck);

		for (int i = 0; i < player.getHandList().size(); i++) {

			if (player.getResult(i) == null) {
				if (dealer.getBust()) {
					player.calcChip(player.getBetChip(i));
					player.setResult("Win", i);
					gi = new GameInf(player, dealer, deck);
				} else {
					player.getHand(i).changeAscore();
					dealer.getHand().changeAscore();
					if (player.getScore(i) > dealer.getScore()) {
						player.calcChip(player.getBetChip(i));
						player.setResult("Win", i);
						gi = new GameInf(player, dealer, deck);
					} else if (player.getScore(i) == dealer.getScore()) {
						player.calcChip(0);
						player.setResult("Draw", i);
						gi = new GameInf(player, dealer, deck);
					} else if (player.getScore(i) < dealer.getScore()) {
						player.calcChip(-player.getBetChip(i));
						player.setResult("Lose", i);
						gi = new GameInf(player, dealer, deck);
					}
				}
			}

		}

		return gi;
	}

}
