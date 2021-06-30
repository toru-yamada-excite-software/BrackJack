package model.actor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import model.card.Deck;
import model.card.Hand;

public class Player implements Serializable {
	private static final long serialVersionUID = -6139991773072896946L;

	private List<BettingBox> bettingBoxes = new ArrayList<>();

	public Player(Deck deck, int betChip) {
		BettingBox hand = new BettingBox(betChip);
		IntStream.range(0, 2).forEach(i -> hand.draw(deck));
		bettingBoxes.add(hand);
	}

	public List<BettingBox> getBoxes() {
		return bettingBoxes;
	}

	public BettingBox getPrimaryBettingBox() {
		return bettingBoxes.get(0);
	}

	public int getWinChip() {
		return bettingBoxes.stream().mapToInt(BettingBox::getWinChip).sum();
	}

	public boolean isGameEnd() {
		return bettingBoxes.stream().allMatch(BettingBox::isEnd);
	}

	public void judgeWinOrLose(Hand dealerHand) {
		bettingBoxes.stream().forEach(box -> box.setResultWinOrLose(dealerHand));
	}

	public void hit(int index, Deck deck) {
		bettingBoxes.get(index).draw(deck);
	}

	public boolean canSplit() {
		return bettingBoxes.size() < 2 && getPrimaryBettingBox().canSplit();
	}

	// return true: エースのスプリット
	public boolean split(Deck deck) {
		if (!canSplit()) {
			throw new IllegalStateException();
		}
		BettingBox newBox = getPrimaryBettingBox().split();
		boolean isAceSplit = newBox.hasAce();
		bettingBoxes.add(newBox);
		bettingBoxes.stream().forEach(hand -> hand.draw(deck));
		return isAceSplit;
	}
}