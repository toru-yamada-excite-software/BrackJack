package model;

import java.util.Date;

public class Game {

	private int id;
	private String userId;
	private int winLose;
	private Date playTime;

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

	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
	}

	public Date getPlayTime() {
		return playTime;
	}

}