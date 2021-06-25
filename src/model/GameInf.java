package model;

import java.io.Serializable;

public class GameInf implements Serializable {
	private static final long serialVersionUID = 9002538034053600564L;

	private Player player;
	private Dealer dealer;
	private Deck deck;

	public GameInf(Player player, Dealer dealer, Deck deck) {

		this.player = player;
		this.dealer = dealer;
		this.deck = deck;

	}

	//	public void setPlayer(Player player) {
	//		this.player = player;
	//	}

	public Player getPlayer() {
		return player;
	}

	//	public void setDealer(Dealer dealer) {
	//		this.dealer = dealer;
	//	}

	public Dealer getDealer() {
		return dealer;
	}

	//	public void setDeck(Deck deck) {
	//		this.deck = deck;
	//	}

	public Deck getDeck() {
		return deck;
	}

}
