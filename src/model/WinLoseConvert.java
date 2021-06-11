package model;

public class WinLoseConvert {

	public String numConvert(Integer chip) {

		if (chip == null) {
			return null;
		}

		if (chip > 0) {
			return "Win";
		} else if (chip == 0) {
			return "Draw";
		} else {
			return "Lose";
		}

	}

	public int strConvert(String str) {

		if (str.equals("Win")) {
			return 0;
		} else if (str.equals("Draw")) {
			return 1;
		} else {
			return 2;
		}

	}

}
