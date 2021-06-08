package model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dbmodel.UserDB;

public class CreateAccountCheckTest {

	@InjectMocks
	private CreateAccountCheck cac = new CreateAccountCheck();;

	@Mock
	private UserDB udb = new UserDB();

	private User user = new User();
	private String id = "test";
	private String password = "test";
	private String name = "test";

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		user.setId(id);
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
		boolean actual = cac.check(id, "", "", name);

		assertThat(actual, is(expected));

	}

	//名前未入力
	@Test
	public void nameVoidTest() {

		boolean expected = false;
		boolean actual = cac.check(id, password, password, "");

		assertThat(actual, is(expected));

	}

	//ID重複
	@Test
	public void idDuplicateTest() {

		doReturn(true).when(udb).getUser(anyString());

		boolean expected = false;
		boolean actual = cac.check(id, "pass", "pass", "name");

		assertThat(actual, is(expected));

	}

	//ID文字コード
	@Test
	public void idCharCodeTest() {

		boolean expected = false;
		boolean actual = cac.check("あ", "pass", "pass", "name");

		assertThat(actual, is(expected));

	}

	//パスワード文字コード
	@Test
	public void passwordCharCodeTest() {

		boolean expected = false;
		boolean actual = cac.check("id", "あ", "あ", "name");

		assertThat(actual, is(expected));

	}

	//アカウント追加成功
	@Test
	public void createSuccessTest() {

		boolean expected = true;
		boolean actual = cac.check("id", password, password, name);

		assertThat(actual, is(expected));

	}

}
