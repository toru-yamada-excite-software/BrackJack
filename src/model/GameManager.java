package model;

public class GameManager {

	private HitOrStand hos = new HitOrStand();

	public GameInf GameManagement(GameInf gi, int command, int chip) {

		if (command == 0 || command == 1) {
			return hos.doHit(gi, chip, command);
		} else {
			return hos.doStand(gi, chip);
		}

	}

	public GameInf naturalBJ(GameInf gi, int chip) {

		Player player = gi.getPlayer();
		Dealer dealer = gi.getDealer();
		Deck deckInf = gi.getDeck();

		if (dealer.getHand().getAscore() == 21 || player.getHand(0).getAscore() == 21) {

			player.getHand(0).changeAscore();
			dealer.getHand().changeAscore();

			if (dealer.getHand().getScore() == 21 && player.getHand(0).getScore() == 21) {
				player.getHand(0).setChip(0);
				gi = new GameInf(player, dealer, deckInf);
			} else if (dealer.getHand().getScore() == 21) {
				player.getHand(0).setChip(-chip);
				gi = new GameInf(player, dealer, deckInf);
			} else {
				player.getHand(0).setChip((int) (chip * 1.5));
				gi = new GameInf(player, dealer, deckInf);
			}

		}

		return gi;
	}

}
