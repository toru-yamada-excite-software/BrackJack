package model;

public class EndProcess {

	public void setResult(Hand hand, Result result) {

		hand.setGetChip(result.getCoefficient());
		hand.setResult(result.getResult());

	}

}
