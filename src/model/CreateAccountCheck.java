package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dbmodel.UserDB;

public class CreateAccountCheck {

	public boolean check(String id, String password1, String password2, String name) {

		//パスワード一致判定
		if (password1.equals(password2)) {

			UserDB udb = new UserDB();

			//空文字判定、ID重複判定
			if (id.equals("") || password1.equals("") || name.equals("")) {
				return false;
			} else if (udb.getUser(id) != null) {
				return false;
			}

			//文字コード判定
			Pattern p = Pattern.compile("^[0-9A-Za-z!-/:-@^_]+$");
			Matcher m1 = p.matcher(id);
			Matcher m2 = p.matcher(password1);

			if (m1.matches() && m2.matches()) {
				return true;
			}

			return false;
		}

		return false;
	}

}
