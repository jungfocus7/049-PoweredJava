public final class RequireTester {
	private static void println(String txt) {
		System.out.println(txt);
	}

	public static void main(String[] args) {
		String txt = """
xxxxxx
yyyyyy
zzzzzz
111111

				""".trim();


		println(txt);

		println(">>>");
	}

}
