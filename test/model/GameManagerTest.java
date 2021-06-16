package model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GameManagerTest {

	@InjectMocks
	private GameManager gm = new GameManager();

	@Mock
	private HitOrStand hos = new HitOrStand();

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void GameManagement0Test() {

		GameInf gi = new GameInf(null, null, null);

		doReturn(gi).when(hos).doHit(anyObject());

		GameInf actualGi = gm.GameManagement(gi, 0);

		String expected = "Win";
		String actual = actualGi.getMessage();

		assertThat(actual, is(expected));

	}

	@Test
	public void GameManagement1Test() {

		GameInf gi = new GameInf(null, null, null);

		doReturn(gi).when(hos).doStand(anyObject());

		GameInf actualGi = gm.GameManagement(gi, 1);

		String expected = "Lose";
		String actual = actualGi.getMessage();

		assertThat(actual, is(expected));

	}

	@Test
	public void naturalBJdrawTest() {

		Player player = new Player();
		Dealer dealer = new Dealer();
		player.setAscore(21);
		dealer.setAscore(21);

		GameInf gi = new GameInf(player, dealer, null);
		GameInf actualGi = gm.naturalBJ(gi);

		String expected = "Draw";
		String actual = actualGi.getMessage();

		assertThat(actual, is(expected));

	}

	@Test
	public void naturalBloseTest() {

		Player player = new Player();
		Dealer dealer = new Dealer();
		player.setAscore(20);
		dealer.setAscore(21);

		GameInf gi = new GameInf(player, dealer, null);
		GameInf actualGi = gm.naturalBJ(gi);

		String expected = "Lose";
		String actual = actualGi.getMessage();

		assertThat(actual, is(expected));

	}

	@Test
	public void naturalBwinTest() {

		Player player = new Player();
		Dealer dealer = new Dealer();
		player.setAscore(21);
		dealer.setAscore(20);

		GameInf gi = new GameInf(player, dealer, null);
		GameInf actualGi = gm.naturalBJ(gi);

		String expected = "Win";
		String actual = actualGi.getMessage();

		assertThat(actual, is(expected));

	}

	@Test
	public void nonNaturalBJTest() {

		Player player = new Player();
		Dealer dealer = new Dealer();
		player.setAscore(20);
		dealer.setAscore(20);

		GameInf gi = new GameInf(player, dealer, null);
		GameInf actualGi = gm.naturalBJ(gi);

		String expected = "null";
		String actual = actualGi.getMessage();

		assertThat(actual, is(expected));

	}

}
