package model.actor;

public enum Result {

	WIN("Win", 1), DRAW("Draw", 0), LOSE("Lose", -1), NB_WIN("Win", 1.5);

	private String result;
	private double coefficient;

	private Result(String result, double coefficient) {
		this.result = result;
		this.coefficient = coefficient;
	}

	public String toString() {
		return result;
	}

	public int getWinChip(int betChip) {
		return (int) (betChip * coefficient);
	}

}
