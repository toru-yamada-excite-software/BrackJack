package dbmodel;

import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.User;

public class UserDBTest {

	private UserDB udb = new UserDB();
	private User user = new User();
	private String id = "2";
	private String password = "pass";
	private String name = "name";

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

	//getUser(id,password)テスト
	@Test
	public void getUserTest1() {

		String expectedId = user.getId();
		String expectedPassword = user.getPassword();
		String expectedName = user.getName();

		User actualuser = udb.getUser(id, password);
		String actualId = actualuser.getId();
		String actualPassword = actualuser.getPassword();
		String actualName = actualuser.getName();

		assertEquals(expectedId, actualId);
		assertEquals(expectedPassword, actualPassword);
		assertEquals(expectedName, actualName);

	}

	//getUser(id)テスト
	@Test
	public void getUserTest2() {

		String expectedId = user.getId();
		String expectedPassword = user.getPassword();
		String expectedName = user.getName();

		User actualuser = udb.getUser(id);
		String actualId = actualuser.getId();
		String actualPassword = actualuser.getPassword();
		String actualName = actualuser.getName();

		assertEquals(expectedId, actualId);
		assertEquals(expectedPassword, actualPassword);
		assertEquals(expectedName, actualName);

	}

	//updateUserテスト
	@Test
	public void updateUserTest() {

		User setUser = new User();
		setUser.setId(id);
		setUser.setPassword(password);
		setUser.setName("name2");

		udb.updateUser(setUser);
		User getUser = udb.getUser(id);

		String expected = "name2";
		String actual = getUser.getName();

		assertEquals(expected, actual);

	}

}
