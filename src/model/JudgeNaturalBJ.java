package model;

public class JudgeNaturalBJ {

	public GameInf judge(GameInf gi) {

		Player player = gi.getPlayer();
		Dealer dealer = gi.getDealer();
		Deck deck = gi.getDeck();
		Hand hand = player.getHandList().get(0);

		if (dealer.getAscore() == 21 || hand.getAscore() == 21) {

			hand.changeAscore();
			dealer.getHand().changeAscore();

			if (dealer.getScore() == 21 && hand.getScore() == 21) {
				player.calcChip(0);
				hand.setResult("Draw");
				gi = new GameInf(player, dealer, deck);
			} else if (dealer.getScore() == 21) {
				player.calcChip(-hand.getChip());
				hand.setResult("Lose");
				gi = new GameInf(player, dealer, deck);
			} else {
				player.calcChip((int) (hand.getChip() * 1.5));
				hand.setResult("Win");
				gi = new GameInf(player, dealer, deck);
			}

		}

		return gi;
	}

}
