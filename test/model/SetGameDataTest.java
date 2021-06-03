package model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dbmodel.GameDB;
import dbmodel.UserDB;

public class SetGameDataTest {

	private User user;
	private String judge;
	private Game game;

	@InjectMocks
	private SetGameData sgd = new SetGameData();

	@Mock
	private GameDB gdb;

	@Mock
	private UserDB udb;

	@BeforeEach
	public void setup() {

		MockitoAnnotations.initMocks(this);
		user = new User();
		user.setId("1");
		user.setPassword("p");
		user.setName("n");
		user.setPlay(9);
		user.setWin(9);
		user.setDraw(0);
		user.setWinRate(1);
		game = new Game("1", 1, null);

	}

	@Test
	public void setDateTestNull() {

		judge = null;
		user = sgd.setData(user, judge);

		int expectedPlay = 9;
		int expectedWin = 9;
		int expectedDraw = 0;
		double expectedWinRate = 1;

		int actualPlay = user.getPlay();
		int actualWin = user.getWin();
		int actualDraw = user.getDraw();
		double actualWinRate = user.getWinRate();

		assertThat(actualPlay, is(expectedPlay));
		assertThat(actualWin, is(expectedWin));
		assertThat(actualDraw, is(expectedDraw));
		assertThat(actualWinRate, is(expectedWinRate));

	}

	@Test
	public void setDateTest() {

		judge = "Win";

		doNothing().when(gdb).insertGame(game);
		doNothing().when(udb).updateUserRecord(user);

		user = sgd.setData(user, judge);

		int expectedPlay = 10;
		int expectedWin = 10;
		int expectedDraw = 0;
		double expectedWinRate = 1;

		int actualPlay = user.getPlay();
		int actualWin = user.getWin();
		int actualDraw = user.getDraw();
		double actualWinRate = user.getWinRate();

		assertThat(actualPlay, is(expectedPlay));
		assertThat(actualWin, is(expectedWin));
		assertThat(actualDraw, is(expectedDraw));
		assertThat(actualWinRate, is(expectedWinRate));

	}

}
