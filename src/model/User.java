package model;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 4509887642700492318L;

	private String id;
	private String password;
	private String name;
	private int play;
	private int chip;
	private int differenceChip = 0;

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

	public void setChip(int chip) {
		this.chip = chip;
	}

	public int getChip() {
		return chip;
	}

	public void setDifferenceChip(int getChip) {
		differenceChip = getChip;
	}

	public int getDifferenceChip() {
		return differenceChip;
	}

}
