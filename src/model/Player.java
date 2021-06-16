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

	public void firstDraw(Deck deck) {

		for (int i = 0; i < 2; i++) {
			handList.get(0).drawBase(deck);
		}

		split = handList.get(0).judgeSplit();
	}

	public boolean permitSplit() {

		if (handList.size() >= 2 || getHand(0).getHand().size() >= 3) {
			split = false;
		}

		return split;
	}

	public boolean getBust(int index) {
		return handList.get(index).getBust();
	}

	public void setChip(Integer betChip, int index) {
		handList.get(index).setChip(betChip);
	}

	public Integer getBetChip(int index) {
		return handList.get(index).getChip();
	}

	public int getScore(int index) {
		return handList.get(index).getScore();
	}

	public int getAscore(int index) {
		return handList.get(index).getAscore();
	}

	public void setResult(String result, int index) {
		handList.get(index).setResult(result);
	}

	public String getResult(int index) {
		return handList.get(index).getResult();
	}

	public boolean getSplit() {
		return split;
	}

	public void setHand(Hand hand) {
		handList.add(hand);
	}

	public Hand getHand(int index) {
		return handList.get(index);
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