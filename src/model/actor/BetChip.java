package model.actor;

import java.io.Serializable;

public class BetChip implements Serializable {
	private static final long serialVersionUID = 1016063109006754528L;

	private int betChip;
	private Result result;

	public BetChip(int betChip) {
		this.betChip = betChip;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Result getResult() {
		return result;
	}

	public void setChip(int betChip) {
		this.betChip = betChip;
	}

	public int getChip() {
		return betChip;
	}

	public int getWinChip() {
		return result == null ? 0 : result.getWinChip(betChip);
	}
}