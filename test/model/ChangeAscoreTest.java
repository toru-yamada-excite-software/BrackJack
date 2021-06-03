package model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChangeAscoreTest {

	ChangeAscore ca;

	@BeforeEach
	public void setup() {
		ca = new ChangeAscore();
	}

	@Test
	public void changePlayerAscoreTest() {

		Player player = new Player();
		player.setAscore(21);

		int expected = 21;
		Player actualPlayer = ca.changePlayerAscore(player);
		int actual = actualPlayer.getScore();

		assertThat(actual, is(expected));

	}

	@Test
	public void changeDealerAscoreTest() {

		Dealer dealer = new Dealer();
		dealer.setAscore(21);

		int expected = 21;
		Dealer actualDealer = ca.changeDealerAscore(dealer);
		int actual = actualDealer.getScore();

		assertThat(actual, is(expected));

	}

}
