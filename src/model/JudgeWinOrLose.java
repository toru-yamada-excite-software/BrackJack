package model;

import java.util.ArrayList;

public class JudgeWinOrLose {

	public void judgeScore(Player player, Dealer dealer) {

		ArrayList<Hand> handList = player.getHandList();
		EndProcess ep = new EndProcess();

		for (int i = 0; i < handList.size(); i++) {

			Hand playerHand = handList.get(i);

			if (playerHand.getResult() == null) {
				if (dealer.getBust()) {
					ep.setResult(handList.get(i), Result.getByResult("Win"));
				} else {

					if (playerHand.getHighScore() > dealer.getHighScore()) {
						ep.setResult(handList.get(i), Result.getByResult("Win"));
					} else if (playerHand.getHighScore() == dealer.getHighScore()) {
						ep.setResult(handList.get(i), Result.getByResult("Draw"));
					} else if (playerHand.getHighScore() < dealer.getHighScore()) {
						ep.setResult(handList.get(i), Result.getByResult("Lose"));
					}
				}
			}

		}

	}

}
