package model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountCheckTest {

	private CreateAccountCheck cac;

	@BeforeEach
	public void name() {
		cac = new CreateAccountCheck();
	}

	@Test
	public void passMachTest() {

		boolean expected = false;
		boolean actual = cac.check("2", "p", "a");

		assertThat(actual, is(expected));

	}

	@Test
	public void charVoidTest1() {

		boolean expected = false;
		boolean actual = cac.check("", "p", "p");

		assertThat(actual, is(expected));

	}

	@Test
	public void charVoidTest2() {

		boolean expected = false;
		boolean actual = cac.check("2", "", "");

		assertThat(actual, is(expected));

	}

	@Test
	public void idDuplicate() {

		boolean expected = false;
		boolean actual = cac.check("1", "p", "p");

		assertThat(actual, is(expected));

	}

	@Test
	public void createSuccessTest() {

		boolean expected = true;
		boolean actual = cac.check("2", "p", "p");

		assertThat(actual, is(expected));

	}

}
