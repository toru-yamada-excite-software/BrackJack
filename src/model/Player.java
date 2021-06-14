package model;

import java.util.ArrayList;

public class Player {

	private ArrayList<Hand> handList = new ArrayList<Hand>();
	private boolean split = false;

	public Player() {
		handList.add(new Hand());
	}

	public void draw(Deck deck, int index) {

		handList.get(index).drawBase(deck);
		handList.get(index).bustJudge();

	}

	public void firstDraw(Deck deck) {

		for (int i = 0; i < 2; i++) {
			handList.get(0).drawBase(deck);
		}

		judgeSplit();
	}

	public void judgeSplit() {

		if (handList.get(0).getHand().get(0).getNumber() == handList.get(0).getHand().get(1).getNumber()) {
			split = true;
		} else if (handList.get(0).getHand().get(0).getNumber() >= 10
				&& handList.get(0).getHand().get(1).getNumber() >= 10) {
			split = true;
		}

	}

	public boolean getBust(int index) {
		return handList.get(index).getBust();
	}

	public void setChip(Integer betChip, int index) {
		handList.get(index).setChip(betChip);
	}

	public Integer getChip(int index) {
		return handList.get(index).getChip();
	}

	public int getScore(int index) {
		return handList.get(index).getScore();
	}

	public int getAscore(int index) {
		return handList.get(index).getAscore();
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

}