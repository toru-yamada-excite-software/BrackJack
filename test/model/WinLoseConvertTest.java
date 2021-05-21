package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WinLoseConvertTest {

	private WinLoseConvert wlc = new WinLoseConvert();;

	@Test
	public void winTest() {

		String expected = "勝ち";
		String actual = wlc.convert(0);

		assertEquals(expected, actual);

	}

	@Test
	public void drawTest() {

		String expected = "引き分け";
		String actual = wlc.convert(1);

		assertEquals(expected, actual);

	}

	@Test
	public void winLose() {

		String expected = "負け";
		String actual = wlc.convert(2);

		assertEquals(expected, actual);

	}

}
