package hbx.helpers;

public final class StringHelper {
	private StringHelper() {
	}

	/**
	 * 빈 문자열
	 */
	public static final String empty = "";

	/**
	 * 빈 문자열인지 확인
	 *
	 * @param str 문자열
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return (str == null) || (str.length() == 0);
	}

	/**
	 * 빈 문자열인지 확인 (공백제거)
	 *
	 * @param str
	 * @return
	 */
	public static boolean checkEmpty(String str) {
		return (str == null) || empty.equals(str.trim());
	}

	/**
	 * 문자열이 유효한지 확인
	 *
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return (str != null) && (str.length() > 0);
	}

	/**
	 * 문자열이 유효한지 확인
	 *
	 * @param str
	 * @return
	 */
	public static boolean checkNotEmpty(String str) {
		return (str != null) && (empty.equals(str.trim()) == false);
	}

	/**
	 * null을 빈 문자열로
	 *
	 * @param str
	 * @return
	 */
	public static String checkNull(String str) {
		if (str == null) {
			return empty;
		}
		else {
			return str;
		}
	}

	/**
	 *
	 * @param str 문자열
	 * @param tw  TotalWidth
	 * @param pc  PaddingChar
	 * @return
	 */
	public static String padLeft(String str, int tw, char pc) {
		if (isEmpty(str)) {
			return empty;
		}

		int lw = str.length();
		if (lw >= tw) {
			return str;
		}

		char[] cha = new char[tw];
		int i = cha.length, j = lw;
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
