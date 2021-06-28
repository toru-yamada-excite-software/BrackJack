package model;

public class Stand {

	public GameInf doStand(GameInf gi) {

		Player player = gi.getPlayer();
		Dealer dealer = gi.getDealer();
		Deck deck = gi.getDeck();

		dealer.draw(deck);

		JudgeWinOrLose jwol = new JudgeWinOrLose();
		jwol.judgeScore(player, dealer);

		return gi;
	}

}
