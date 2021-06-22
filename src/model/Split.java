package model;

public class Split {

	private Stand stand = new Stand();

	public GameInf doSplit(GameInf gi) {

		Player player = gi.getPlayer();

		Card card = player.getHandList().get(0).getHand().poll();
		Hand hand = new Hand();
		hand.setHand(card);
		hand.setChip(player.getHandList().get(0).getChip());
		player.setHand(hand);
		player.draw(gi.getDeck(), 0);
		player.draw(gi.getDeck(), 1);

		if (player.getHandList().get(0).getHand().get(0).getNumber() == 1) {
			gi = stand.doStand(gi);
		}

		return gi;
	}

}
