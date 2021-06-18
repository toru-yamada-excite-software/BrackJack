package model;

public class GameManager {

	private HitOrStand hos = new HitOrStand();

	public GameInf gameManagement(GameInf gi, int command) {

		if (command == 0 || command == 1) {
			return hos.doHit(gi, command);
		} else {
			return hos.doStand(gi);
		}

	}

	public GameInf naturalBJ(GameInf gi) {

		Player player = gi.getPlayer();
		Dealer dealer = gi.getDealer();
		Deck deckInf = gi.getDeck();

		if (dealer.getAscore() == 21 || player.getAscore(0) == 21) {

			player.getHand(0).changeAscore();
			dealer.getHand().changeAscore();

			if (dealer.getScore() == 21 && player.getScore(0) == 21) {
				player.calcChip(0);
				player.setResult("Draw", 0);
				gi = new GameInf(player, dealer, deckInf);
			} else if (dealer.getScore() == 21) {
				player.calcChip(-player.getBetChip(0));
				player.setResult("Lose", 0);
				gi = new GameInf(player, dealer, deckInf);
			} else {
				player.calcChip((int) (player.getBetChip(0) * 1.5));
				player.setResult("Win", 0);
				gi = new GameInf(player, dealer, deckInf);
			}

		}

		return gi;
	}

}
