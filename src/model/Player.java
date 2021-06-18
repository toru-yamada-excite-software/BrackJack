package model;

import java.util.ArrayList;

public class Player {

	private ArrayList<Hand> handList = new ArrayList<Hand>();
	private int chip;
	private boolean split = false;

	public Player(int chip) {
		handList.add(new Hand());
		this.chip = chip;
	}

	public void draw(Deck deck, int index) {

		handList.get(index).drawBase(deck);

	}

	public void firstDraw(Deck deck, int betChip) {

		for (int i = 0; i < 2; i++) {
			handList.get(0).drawBase(deck);
		}

		handList.get(0).setChip(betChip);
		split = handList.get(0).judgeSplit();
	}

	public boolean permitSplit() {

		if (handList.size() >= 2 || handList.get(0).getHand().size() >= 3) {
			split = false;
		}

		return split;
	}

	public boolean getSplit() {
		return split;
	}

	public void setHand(Hand hand) {
		handList.add(hand);
	}

	public ArrayList<Hand> getHandList() {
		return handList;
	}

	public void calcChip(int getChip) {
		chip += getChip;
	}

	public int getChip() {
		return chip;
	}

}