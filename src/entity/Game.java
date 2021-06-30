package entity;

import java.sql.Timestamp;

public class Game {

	private User user;
	private int chip;
	//	private int winLose;
	private Timestamp playTime;

	public Game(User user, int chip, Timestamp playTime) {
		this.user = user;
		this.chip = chip;
		this.playTime = playTime;
	}

	public String getUserId() {
		return user.getId();
	}

	public int getChip() {
		return chip;
	}

	public Timestamp getPlayTime() {
		return playTime;
	}

}