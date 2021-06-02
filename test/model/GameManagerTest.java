package model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GameManagerTest {

	Deck deck = new Deck();

	@Mock
	private Player player;

	Dealer dealer = new Dealer();
	int command = 0;
	GameInf gi = new GameInf(player, dealer, deck, null);

	@InjectMocks
	private GameManager gm = new GameManager(gi, command);

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void GameManagementTest1() {

		doReturn(deck).when(player).draw(any());
		doReturn(true).when(player).getBust();

		gi = gm.GameManagement();

		String expected = "Lose";
		String actual = gi.getMessage();

		assertThat(actual, is(expected));

	}

}
