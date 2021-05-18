package model;

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

			return true;
		}

		return false;
	}

}
