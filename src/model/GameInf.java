package model;

import java.io.Serializable;

public class GameInf implements Serializable {
	private static final long serialVersionUID = 9002538034053600564L;

	private Player player;
	private Player splitPlayer;
	private Dealer dealer;
	private Deck deck;
	private Integer chip;
	private Integer splitChip;

	public GameInf(Player player, Player splitPlayer, Dealer dealer, Deck deck, Integer chip, Integer splitChip) {

		this.player = player;
		this.splitPlayer = splitPlayer;
		this.dealer = dealer;
		this.deck = deck;
		this.chip = chip;
		this.splitChip = splitChip;

	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void setSplitPlayer(Player splitPlayer) {
		this.splitPlayer = splitPlayer;
	}

	public Player getSplitPlayer() {
		return splitPlayer;
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

	public void setSplitChip(Integer betChip) {
		this.splitChip = betChip;
	}

	public Integer getSplitChip() {
		return splitChip;
	}

}
