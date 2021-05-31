package model;

public class GameInf {

	private Player player;
	private Dealer dealer;
	private Deck deck;
	private String message;

	public GameInf(Player player, Dealer dealer, Deck deck, String message) {

		this.player = player;
		this.dealer = dealer;
		this.deck = deck;
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

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
