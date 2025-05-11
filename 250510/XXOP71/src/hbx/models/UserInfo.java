package hbx.models;

import hbx.helpers.StringHelper;
//import java.text.MessageFormat;


public final class UserInfo {
	private static int _numCount;
	static {
		_numCount = 103;
	}

	private static int _get_numCount() {
		return ++_numCount;
	}


	public UserInfo(String email, String password, String name) {
		_num = _get_numCount();
		set_email(email);
		set_password(password);
		set_name(name);
	}

	public UserInfo(String email) {
		_num = _get_numCount();
		set_email(email);
	}


	private int _num;
	public int get_num() {
		return _num;
	}


	private String _email;
	public String get_email() {
		return _email;
	}
	public void set_email(String val) {
		if (val == _email) {
			return;
		}
		_email = val;
	}


	private String _password;
	public String get_password() {
		return _password;
	}
	public void set_password(String val) {
		if (val == _password) {
			return;
		}
		_password = val;
	}


	private String _name;
	public String get_name() {
		return _name;
	}
	public void set_name(String val) {
		if (val == _name) {
			return;
		}
		_name = val;
	}


	private boolean _checkLoginCore() {
		return false;
	}

	private boolean _bLogin = false;
	public boolean checkLogin() {
		String email = get_email();
		String password = get_password();
		if (StringHelper.checkEmpty(email) ||
			StringHelper.checkEmpty(password)) {
			_bLogin = false;
		}
		else {
			if (_checkLoginCore()) {
				_bLogin = true;
			}
			else {
				_bLogin = false;
			}
		}

		return _bLogin;
	}


	public String get_info() {
//		String txt = """
//				xxxxxxxx
//		""".trim();
//		MessageFormat.format("", null)

		StringBuilder tsb = new StringBuilder();
		tsb.append(String.format("Num=%d; ", get_num()));
		tsb.append(String.format("Email=%s; ", get_email()));
		tsb.append(String.format("Name=%s; ", get_name()));

		String rst = tsb.toString();
		tsb.delete(0, tsb.length());

		return rst;
	}

}
