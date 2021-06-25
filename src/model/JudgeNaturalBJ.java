package model;

public class JudgeNaturalBJ {

	public GameInf judge(GameInf gi) {

		Player player = gi.getPlayer();
		Dealer dealer = gi.getDealer();
		Hand hand = player.getHandList().get(0);

		if (dealer.getHighScore() == 21 || hand.getAscore() == 21) {

			if (dealer.getHighScore() == 21 && hand.getScore() == 21) {
				player.calcChip(0);
				hand.setResult("Draw");
			} else if (dealer.getHighScore() == 21) {
				player.calcChip(-hand.getChip());
				hand.setResult("Lose");
			} else {
				player.calcChip((int) (hand.getChip() * 1.5));
				hand.setResult("Win");
			}

		}

		return gi;
	}

}
