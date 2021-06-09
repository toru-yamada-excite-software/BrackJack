package model;

import java.sql.Timestamp;

public class Game {

	private int id;
	private String userId;
	private int chip;
	//	private int winLose;
	private Timestamp playTime;

	public Game(String userId, int chip, Timestamp playTime) {
		this.userId = userId;
		this.chip = chip;
		this.playTime = playTime;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setChip(int chip) {
		this.chip = chip;
	}

	public int getChip() {
		return chip;
	}

	public void setPlayTime(Timestamp playTime) {
		this.playTime = playTime;
	}

	public Timestamp getPlayTime() {
		return playTime;
	}

}