package hbx.helpers;

public final class DebugHelper {
	private DebugHelper() { }

	public static boolean canPrintable = true;
	/**
	 * 콘솔 출력
	 * @param msg 텍스트
	 */
	public static void println(String msg) {
		if (canPrintable) {
			System.out.println(msg);
		}
	}
}
