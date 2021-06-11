package model;

import java.io.Serializable;

public class GameInf implements Serializable {
	private static final long serialVersionUID = 9002538034053600564L;

	private Player player;
	private Dealer dealer;
	private Deck deck;
	private Integer chip;

	public GameInf(Player player, Dealer dealer, Deck deck, Integer betChip) {

		this.player = player;
		this.dealer = dealer;
		this.deck = deck;
		this.chip = betChip;

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

	public void setChip(Integer betChip) {
		this.chip = betChip;
	}

	public Integer getChip() {
		return chip;
	}

}
