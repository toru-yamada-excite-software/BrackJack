package model;

public enum Result {

	WIN("Win", 1), DRAW("Draw", 0), LOSE("Lose", -1), NB_WIN("Win(NB)", 1.5);

	private String result;
	private double coefficient;

	private Result(String result, double coefficient) {
		this.result = result;
		this.coefficient = coefficient;
	}

	public String getResult() {
		return result;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public static Result getByResult(String resultId) {

		for (Result result : Result.values()) {
			if (result.getResult() == resultId) {
				return result;
			}
		}

		return null;

	}

}
