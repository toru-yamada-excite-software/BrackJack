package model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.Test;

public class WinLoseConvertTest {

	private WinLoseConvert wlc = new WinLoseConvert();;

	@Test
	public void winTest() {

		String expected = "勝ち";
		String actual = wlc.convert(0);

		assertThat(actual, is(expected));

	}

	@Test
	public void drawTest() {

		String expected = "引き分け";
		String actual = wlc.convert(1);

		assertThat(actual, is(expected));

	}

	@Test
	public void LoseTest() {

		String expected = "負け";
		String actual = wlc.convert(2);

		assertThat(actual, is(expected));

	}

	@Test
	public void errorTest() {

		String expected = "エラー";
		String actual = wlc.convert(3);

		assertThat(actual, is(expected));

	}

}
