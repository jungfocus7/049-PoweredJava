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

	public static String leftPad(String str, int tw, char pc) {
		char[] cha = new char[tw];
		int i = cha.length, j = str.length();
		while (--i >= 0) {
			if (--j >= 0) {
				cha[i] = str.charAt(j);
			}
			else {
				cha[i] = pc;
			}
		}

		String rs = new String(cha);
		return rs;
	}
}
