package model;

import java.io.Serializable;

import model.actor.BettingBox;
import model.actor.Dealer;
import model.actor.Player;
import model.card.Deck;
import model.card.Hand;

public class GameInf implements Serializable {
	private static final long serialVersionUID = 6073427729440418882L;

	private Player player;
	private Dealer dealer;
	private Deck deck;

	public GameInf(Player player, Dealer dealer, Deck deck) {
		this.player = player;
		this.dealer = dealer;
		this.deck = deck;
	}

	public Player getPlayer() {
		return player;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setResultNaturalBlackjack() {
		BettingBox playerHand = player.getPrimaryBettingBox();
		Hand dealerHand = dealer.getHand();
		playerHand.setResultNaturalBlackjack(dealerHand);
	}

	public void stand() {
		dealer.draw(deck);
		player.judgeWinOrLose(dealer.getHand());
	}

	public void hit(int index) {
		player.hit(index, deck);
	}

	public void split() {
		if (player.split(deck)) {
			stand();
		}
	}

}
