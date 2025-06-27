package helpers;

public final class TesterHelper {
	private TesterHelper() {
	}

	public static void println(String txt) {
		System.out.println(txt);
	}

	public static void printLineSeparator() {
		println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		println(System.lineSeparator());
	}

}
