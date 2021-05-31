package model;

import java.sql.Timestamp;

public class Game {

	private int id;
	private String userId;
	private int winLose;
	private Timestamp playTime;

	public Game(String userId, int WinLose, Timestamp playTime) {
		this.userId = userId;
		this.winLose = WinLose;
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

	public void setWinLose(int winLose) {
		this.winLose = winLose;
	}

	public int getWinLose() {
		return winLose;
	}

	public void setPlayTime(Timestamp playTime) {
		this.playTime = playTime;
	}

	public Timestamp getPlayTime() {
		return playTime;
	}

}