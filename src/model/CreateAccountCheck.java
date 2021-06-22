package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dbmodel.UserDB;

public class CreateAccountCheck {

	private static final Pattern ID_PATTERN = Pattern.compile("^[0-9A-Za-z!-/:-@^_]{1,32}$");
	private static final Pattern PASS_PATTERN = Pattern.compile("^[0-9A-Za-z!-/:-@^_]{6,32}$");
	private UserDB udb = new UserDB();

	public boolean check(String id, String password1, String password2, String name) {

		//パスワード一致判定
		if (!password1.equals(password2)) {
			return false;
		}

		//空文字判定、ID重複判定
		if (id.equals("") || password1.equals("") || name.equals("")) {
			return false;
		} else if (udb.getUser(id)) {
			return false;
		}

		//文字コード判定
		Matcher m1 = ID_PATTERN.matcher(id);
		Matcher m2 = PASS_PATTERN.matcher(password1);

		if (m1.matches() && m2.matches()) {
			return true;
		}

		return false;
	}

}
