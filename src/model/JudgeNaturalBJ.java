package model;

public class JudgeNaturalBJ {

	public GameInf judge(GameInf gi) {

		Player player = gi.getPlayer();
		Dealer dealer = gi.getDealer();
		Hand hand = player.getHandList().get(0);
		EndProcess ep = new EndProcess();

		if (dealer.getHighScore() == 21 || hand.getAscore() == 21) {

			if (dealer.getHighScore() == 21 && hand.getScore() == 21) {
				ep.setResult(hand, Result.getByResult("Draw"));
			} else if (dealer.getHighScore() == 21) {
				ep.setResult(hand, Result.getByResult("Lose"));
			} else {
				ep.setResult(hand, Result.getByResult("Win(NB)"));
			}

		}

		return gi;
	}

}
