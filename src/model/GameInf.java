package model;

import java.io.Serializable;

public class GameInf implements Serializable {
	private static final long serialVersionUID = 9002538034053600564L;

	private Player player;
	private Dealer dealer;
	private Deck deck;
	private int chip;
	private String message;

	public GameInf(Player player, Dealer dealer, Deck deck, int betChip, String message) {

		this.player = player;
		this.dealer = dealer;
		this.deck = deck;
		this.chip = betChip;
		this.message = message;

	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setChip(int betChip) {
		this.chip = betChip;
	}

	public int getChip() {
		return chip;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
