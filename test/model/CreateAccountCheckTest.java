package model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dbmodel.UserDB;

public class CreateAccountCheckTest {

	private CreateAccountCheck cac = new CreateAccountCheck();;
	private UserDB udb = new UserDB();
	private User user;
	private String id = "test";
	private String password = "test";
	private String name = "test";

	@BeforeEach
	public void setup() {
		user.setId(id);
		user.setPassword(password);
		user.setName(name);
		udb.insertUser(user);
	}

	@AfterEach
	public void delete() {
		udb.deleteUser(id);
	}

	//確認用パスワードとの不一致
	@Test
	public void passMachTest() {

		boolean expected = false;
		boolean actual = cac.check(id, password, "tes", name);

		assertThat(actual, is(expected));

	}

	//ID未入力
	@Test
	public void idVoidTest() {

		boolean expected = false;
		boolean actual = cac.check("", password, password, name);

		assertThat(actual, is(expected));

	}

	//パスワード未入力
	@Test
	public void passVoidTest() {

		boolean expected = false;
		boolean actual = cac.check("2", "", "", "n2");

		assertThat(actual, is(expected));

	}

	//名前未入力
	@Test
	public void nameVoidTest() {

		boolean expected = false;
		boolean actual = cac.check("2", "p", "p", "");

		assertThat(actual, is(expected));

	}

	//ID重複
	@Test
	public void idDuplicateTest() {

		boolean expected = false;
		boolean actual = cac.check("1", "p", "p", "n2");

		assertThat(actual, is(expected));

	}

	//ID文字コード
	@Test
	public void idCharCodeTest() {

		boolean expected = false;
		boolean actual = cac.check("あ", "p", "p", "n2");

		assertThat(actual, is(expected));

	}

	//パスワード文字コード
	@Test
	public void passwordCharCodeTest() {

		boolean expected = false;
		boolean actual = cac.check("1", "あ", "あ", "n2");

		assertThat(actual, is(expected));

	}

	//アカウント追加成功
	@Test
	public void createSuccessTest() {

		boolean expected = true;
		boolean actual = cac.check("2", "p", "p", "n2");

		assertThat(actual, is(expected));

	}

}
