package model;

public enum Result {

	WIN("Win", 0), DRAW("Draw", 1), LOSE("Lose", 2);

	private String label;
	private int id;

	private Result(String label, int id) {
		this.label = label;
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public int getId() {
		return id;
	}

	public static Result getById(int id) {

		for (Result result : Result.values()) {
			if (result.getId() == id) {
				return result;
			}
		}
		return null;
	}

}
