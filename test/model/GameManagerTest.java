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

	@Mock
	private ChangeAscore ca = new ChangeAscore();

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void GameManagementTest() {

		GameInf gi = new GameInf(null, null, null, "Win");

		doReturn(gi).when(hos).doHit(anyObject());

		GameInf actualGi = gm.GameManagement(gi, 0);

		String expected = "Win";
		String actual = actualGi.getMessage();

		assertThat(actual, is(expected));

	}

}
