package model;

public class Split {

	public GameInf doSplit(GameInf gi) {

		Player player = gi.getPlayer();

		Card card = player.getHandList().get(0).getHand().poll();
		Hand hand = new Hand();
		hand.setHand(card);
		hand.setChip(player.getHandList().get(0).getChip());
		player.setHand(hand);
		player.draw(gi.getDeck(), 0);
		player.draw(gi.getDeck(), 1);

		return gi;
	}

}
