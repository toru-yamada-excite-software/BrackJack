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

public class HitOrStandTest {

	@InjectMocks
	HitOrStand hos = new HitOrStand();

	@Mock
	Player player;

	@Mock
	Dealer dealer;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void doHitTest() {

		Deck deck = new Deck();
		GameInf gi = new GameInf(player, dealer, deck, "");

		doReturn(deck).when(player).draw(anyObject());
		doReturn(false).when(player).getBust();

		GameInf actualGi = hos.doHit(gi);
		String actual = actualGi.getMessage();

		assertThat(actual, nullValue());

	}

	@Test
	public void doHitBustTest() {

		Deck deck = new Deck();
		GameInf gi = new GameInf(player, dealer, deck, null);

		doReturn(deck).when(player).draw(anyObject());
		doReturn(true).when(player).getBust();

		String expected = "Lose";
		GameInf actualGi = hos.doHit(gi);
		String actual = actualGi.getMessage();

		assertThat(actual, is(expected));

	}

	@Test
	public void doStandBustTest() {

		Deck deck = new Deck();
		GameInf gi = new GameInf(player, dealer, deck, null);

		doReturn(deck).when(dealer).draw(anyObject());
		doReturn(true).when(dealer).getBust();

		String expected = "Win";
		GameInf actualGi = hos.doStand(gi);
		String actual = actualGi.getMessage();

		assertThat(actual, is(expected));

	}

	@Test
	public void doStandWinTest() {

		Deck deck = new Deck();
		GameInf gi = new GameInf(player, dealer, deck, null);

		doReturn(deck).when(player).draw(anyObject());
		doReturn(20).when(player).getScore();
		doReturn(19).when(dealer).getScore();

		String expected = "Win";
		GameInf actualGi = hos.doStand(gi);
		String actual = actualGi.getMessage();

		assertThat(actual, is(expected));

	}

	@Test
	public void doStandDrawTest() {

		Deck deck = new Deck();
		GameInf gi = new GameInf(player, dealer, deck, null);

		doReturn(deck).when(player).draw(anyObject());
		doReturn(19).when(player).getScore();
		doReturn(19).when(dealer).getScore();

		String expected = "Draw";
		GameInf actualGi = hos.doStand(gi);
		String actual = actualGi.getMessage();

		assertThat(actual, is(expected));

	}

	@Test
	public void doStandLoseTest() {

		Deck deck = new Deck();
		GameInf gi = new GameInf(player, dealer, deck, null);

		doReturn(deck).when(player).draw(anyObject());
		doReturn(19).when(player).getScore();
		doReturn(20).when(dealer).getScore();

		String expected = "Lose";
		GameInf actualGi = hos.doStand(gi);
		String actual = actualGi.getMessage();

		assertThat(actual, is(expected));

	}

}
