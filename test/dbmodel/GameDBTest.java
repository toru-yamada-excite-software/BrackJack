package dbmodel;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Game;
import model.User;

public class GameDBTest {

	private GameDB gdb = new GameDB();
	private UserDB udb = new UserDB();
	private Game game;
	private User user;
	private String userId = "test";
	private int winLose = 0;
	private Timestamp playTime = new Timestamp(System.currentTimeMillis());

	@BeforeEach
	public void setup() {
		user = new User();
		user.setId(userId);
		user.setPassword("test");
		user.setName("test");
		playTime.setNanos(0);
		game = new Game(userId, winLose, playTime);
		udb.insertUser(user);
		gdb.insertGame(game);
	}

	@AfterEach
	public void delete() {
		gdb.deleteGame(userId);
		udb.deleteUser(userId);
	}

	//getGameテスト
	@Test
	public void getGameTest() throws Exception {

		String expectedUserId = userId;
		int expectedWinLose = winLose;
		Timestamp expectedPlayTime = playTime;

		ArrayList<Game> gameList = (ArrayList<Game>) gdb.getGame(userId);
		String actualUserId = gameList.get(0).getUserId();
		int actualWinLose = gameList.get(0).getWinLose();
		Timestamp actualPlayTime = gameList.get(0).getPlayTime();

		assertThat(actualUserId, is(expectedUserId));
		assertThat(actualWinLose, is(expectedWinLose));
		assertThat(actualPlayTime, is(expectedPlayTime));

	}

}
