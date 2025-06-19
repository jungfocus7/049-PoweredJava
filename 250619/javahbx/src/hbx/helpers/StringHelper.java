package hbx.helpers;

public final class StringHelper {
	private StringHelper() { }

	public static final String empty = "";

	public static boolean isEmpty(String str) {
		return (str == null) || (str.length() == 0);
	}

	public static boolean isNotEmpty(String str) {
		return (str != null) && (str.length() > 0);
	}

	public static String checkNull(String str) {
		if (str == null) {
			return empty;
		}
		else {
			return str;
		}
	}
}
