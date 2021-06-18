package model;

public class JudgeGameEnd {

	public static int judge(Player player) {

		int count = 0;

		for (int i = 0; i < player.getHandList().size(); i++) {
			if (player.getHandList().get(i).getResult() != null) {
				count++;
			}
		}

		return count;
	}

}
