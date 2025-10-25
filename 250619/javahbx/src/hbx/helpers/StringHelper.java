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
	 * 문자열이 유효한지 확인
	 *
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return (str != null) && (str.length() > 0);
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
	 * 문자열이 유효한지 확인 (공백제거)
	 *
	 * @param str
	 * @return
	 */
	public static boolean checkNotEmpty(String str) {
		return (str != null) && (empty.equals(str.trim()) == false);
	}

	/**
	 * 문자열이 공백이거나 유효하지 않으면 true
	 *
	 * @param str 문자열
	 * @return
	 */
	public static boolean isNullOrWhiteSpace(String str) {
		if (str == null) {
			return true;
		}

		boolean bFind = false;
		for (int i = 0, l = str.length(); i < l; i++) {
			char ch = str.charAt(i);
			if (Character.isWhitespace(ch) == false) {
				bFind = true;
				break;
			}
		}

		return bFind == false;
	}

	/**
	 * 문자열이 유효하면 true
	 *
	 * @param str 문자열
	 * @return
	 */
	public static boolean isNotNullOrWhiteSpace(String str) {
		return isNullOrWhiteSpace(str) == false;
	}

	/**
	 * null을 빈 문자열로
	 *
	 * @param str 문자열
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
	 * 문자열에 왼쪽으로 특정문자 채우기
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
		int i = tw, j = lw;
		while (--i >= 0) {
			if (--j >= 0) {
				cha[i] = str.charAt(j);
			}
			else {
				cha[i] = pc;
			}
		}

		String rst = new String(cha);
		return rst;
	}

	/**
	 * 예외 발생없는 문자열이 같은지 비교
	 * @param str1 문자열
	 * @param str2 문자열
	 * @return
	 */
	public static boolean equals(String str1, String str2) {
		if ((str1 != null) && (str2 != null)) {
			return str1.equals(str2);
		}
		else {
			return (str1 == null) && (str2 == null);
		}
	}

	/**
	 * 예외 발생없는 문자열비교 (문자열이 유효한 경우만)
	 * @param str1 문자열
	 * @param str2 문자열
	 * @return
	 */
	public static boolean checkEquals(String str1, String str2) {
		if (checkEmpty(str1) || checkEmpty(str2)) {
			return false;
		}
		else {
			return str1.trim().equals(str2.trim());
		}
	}

}
