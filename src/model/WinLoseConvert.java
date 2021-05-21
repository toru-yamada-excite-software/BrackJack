package model;

public class WinLoseConvert {

	public String convert(int winLose) {

		if (winLose == 0) {
			return "勝ち";
		} else if (winLose == 1) {
			return "引き分け";
		} else if (winLose == 2) {
			return "負け";
		}

		return "エラー";
	}

}
