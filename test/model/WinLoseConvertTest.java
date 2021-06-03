package model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.Test;

public class WinLoseConvertTest {

	private WinLoseConvert wlc = new WinLoseConvert();;

	@Test
	public void winNumTest() {

		String expected = "勝ち";
		String actual = wlc.numConvert(0);

		assertThat(actual, is(expected));

	}

	@Test
	public void drawNumTest() {

		String expected = "引き分け";
		String actual = wlc.numConvert(1);

		assertThat(actual, is(expected));

	}

	@Test
	public void LoseNumTest() {

		String expected = "負け";
		String actual = wlc.numConvert(2);

		assertThat(actual, is(expected));

	}

	@Test
	public void winStrTest() {

		int expected = 0;
		int actual = wlc.StrConvert("Win");

		assertThat(actual, is(expected));

	}

	@Test
	public void drawStrTest() {

		int expected = 1;
		int actual = wlc.StrConvert("Draw");

		assertThat(actual, is(expected));

	}

	@Test
	public void LoseStrTest() {

		int expected = 2;
		int actual = wlc.StrConvert("Lose");

		assertThat(actual, is(expected));

	}

}
