package dbmodel;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Game;

public class GameDBTest {

	private GameDB gdb = new GameDB();

	//getGameテスト
	@Test
	public void getGameTest() throws Exception {

		int expectedId = 4;
		String expectedUserId = "id";
		int expectedWinLose = 0;

		ArrayList<Game> gameList = (ArrayList<Game>) gdb.getGame("id");
		int actualId = gameList.get(0).getId();
		String actualUserId = gameList.get(0).getUserId();
		int actualWinLose = gameList.get(0).getWinLose();

		assertThat(actualId, is(expectedId));
		assertThat(actualUserId, is(expectedUserId));
		assertThat(actualWinLose, is(expectedWinLose));

	}

}
