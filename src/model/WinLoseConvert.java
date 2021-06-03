package model;

public class WinLoseConvert {

	public String numConvert(int winLose) {

		if (winLose == 0) {
			return "勝ち";
		} else if (winLose == 1) {
			return "引き分け";
		} else {
			return "負け";
		}

	}

	public int StrConvert(String str) {

		if (str.equals("Win")) {
			return 0;
		} else if (str.equals("Draw")) {
			return 1;
		} else {
			return 2;
		}

	}

}
