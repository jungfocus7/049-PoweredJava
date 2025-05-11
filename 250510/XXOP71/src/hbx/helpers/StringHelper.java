package hbx.helpers;

public final class StringHelper {
	public static boolean checkEmpty(String val) {
		if ((val == null) || val.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
}
