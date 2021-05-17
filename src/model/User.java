package model;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 4509887642700492318L;

	private String id;
	private String password;
	private String name;
	private int play;
	private int win;
	private int draw;
	private double winLate;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPlay(int play) {
		this.play = play;
	}

	public int getPlay() {
		return play;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getWin() {
		return win;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getDraw() {
		return draw;
	}

	public void setWinLate(double winLate) {
		this.winLate = winLate;
	}

	public double getWinLate() {
		return winLate;
	}

}
