import hbx.helpers.StringHelper;
import helpers.TesterHelper;

public final class TestWork__StringHelper {
	private TestWork__StringHelper() {
	}

	private static void test30() {
		boolean br;

		br = StringHelper.isEmpty(null);
		TesterHelper.println("StringHelper.isEmpty(null); " + br);
		br = StringHelper.isEmpty(StringHelper.empty);
		TesterHelper.println("StringHelper.isEmpty(StringHelper.empty); " + br);
		br = StringHelper.isEmpty("박종명");
		TesterHelper.println("StringHelper.isEmpty(\"박종명\"); " + br);
		br = StringHelper.isEmpty("  ");
		TesterHelper.println("StringHelper.isEmpty(\"  \"); " + br);
		TesterHelper.printLineSeparator();

		br = StringHelper.isNotEmpty(null);
		TesterHelper.println("StringHelper.isNotEmpty(null); " + br);
		br = StringHelper.isNotEmpty(StringHelper.empty);
		TesterHelper.println("StringHelper.isNotEmpty(StringHelper.empty); " + br);
		br = StringHelper.isNotEmpty("박종명");
		TesterHelper.println("StringHelper.isNotEmpty(\"박종명\"); " + br);
		br = StringHelper.isNotEmpty("  ");
		TesterHelper.println("StringHelper.isNotEmpty(\"  \"); " + br);
		TesterHelper.printLineSeparator();

		br = StringHelper.checkEmpty(null);
		TesterHelper.println("StringHelper.checkEmpty(null); " + br);
		br = StringHelper.checkEmpty(StringHelper.empty);
		TesterHelper.println("StringHelper.checkEmpty(StringHelper.empty); " + br);
		br = StringHelper.checkEmpty("박종명");
		TesterHelper.println("StringHelper.checkEmpty(\"박종명\"); " + br);
		br = StringHelper.checkEmpty("  ");
		TesterHelper.println("StringHelper.checkEmpty(\"  \"); " + br);
		TesterHelper.printLineSeparator();

		br = StringHelper.checkNotEmpty(null);
		TesterHelper.println("StringHelper.checkNotEmpty(null); " + br);
		br = StringHelper.checkNotEmpty(StringHelper.empty);
		TesterHelper.println("StringHelper.checkNotEmpty(StringHelper.empty); " + br);
		br = StringHelper.checkNotEmpty("박종명");
		TesterHelper.println("StringHelper.checkNotEmpty(\"박종명\"); " + br);
		br = StringHelper.checkNotEmpty("  ");
		TesterHelper.println("StringHelper.checkNotEmpty(\"  \"); " + br);
		TesterHelper.printLineSeparator();

		br = StringHelper.isNullOrWhitespace(null);
		TesterHelper.println("StringHelper.isNullOrWhitespace(null); " + br);
		br = StringHelper.isNullOrWhitespace(StringHelper.empty);
		TesterHelper.println("StringHelper.isNullOrWhitespace(StringHelper.empty); " + br);
		br = StringHelper.isNullOrWhitespace("박종명");
		TesterHelper.println("StringHelper.isNullOrWhitespace(\"박종명\"); " + br);
		br = StringHelper.isNullOrWhitespace("  ");
		TesterHelper.println("StringHelper.isNullOrWhitespace(\"  \"); " + br);
		TesterHelper.printLineSeparator();

		br = StringHelper.isNotNullOrWhiteSpace(null);
		TesterHelper.println("StringHelper.isNotNullOrWhiteSpace(null); " + br);
		br = StringHelper.isNotNullOrWhiteSpace(StringHelper.empty);
		TesterHelper.println("StringHelper.isNotNullOrWhiteSpace(StringHelper.empty); " + br);
		br = StringHelper.isNotNullOrWhiteSpace("박종명");
		TesterHelper.println("StringHelper.isNotNullOrWhiteSpace(\"박종명\"); " + br);
		br = StringHelper.isNotNullOrWhiteSpace("  ");
		TesterHelper.println("StringHelper.isNotNullOrWhiteSpace(\"  \"); " + br);
		TesterHelper.printLineSeparator();


		String rst;

		rst = StringHelper.checkNull("임헌진");
		TesterHelper.println("StringHelper.checkNull(\"임헌진\"); " + rst);
		rst = StringHelper.checkNull("");
		TesterHelper.println("StringHelper.checkNull(\"\"); " + rst);
		rst = StringHelper.checkNull(null);
		TesterHelper.println("StringHelper.checkNull(null); " + rst);
		TesterHelper.printLineSeparator();

		rst = StringHelper.padLeft("321", 5, 'x');
		TesterHelper.println("StringHelper.padLeft(\"321\", 5, 'x'); " + rst);
		rst = StringHelper.padLeft("abcdefg", 10, '0');
		TesterHelper.println("StringHelper.padLeft(\"abcdefg\", 10, '0'); " + rst);
		rst = StringHelper.padLeft("0123456789", 7, '#');
		TesterHelper.println("StringHelper.padLeft(\"0123456789\", 7, '#'); " + rst);
		TesterHelper.printLineSeparator();


		br = StringHelper.equals("", "");
		TesterHelper.println("StringHelper.equals(\"\", \"\"); " + br);
		br = StringHelper.equals(null, null);
		TesterHelper.println("StringHelper.equals(null, null); " + br);
		br = StringHelper.equals("pook61", "pook61");
		TesterHelper.println("StringHelper.equals(\"pook61\", \"pook61\"); " + br);
		br = StringHelper.equals("inoff79", "");
		TesterHelper.println("StringHelper.equals(\"inoff79\", \"\"); " + br);
		br = StringHelper.equals(null, "inoff79");
		TesterHelper.println("StringHelper.equals(null, \"inoff79\"); " + br);
		TesterHelper.printLineSeparator();


		br = StringHelper.checkEquals("", "");
		TesterHelper.println("StringHelper.checkEquals(\"\", \"\"); " + br);
		br = StringHelper.checkEquals(null, null);
		TesterHelper.println("StringHelper.checkEquals(null, null); " + br);
		br = StringHelper.checkEquals("pook61", "pook61");
		TesterHelper.println("StringHelper.checkEquals(\"pook61\", \"pook61\"); " + br);
		br = StringHelper.checkEquals("inoff79", "");
		TesterHelper.println("StringHelper.checkEquals(\"inoff79\", \"\"); " + br);
		br = StringHelper.checkEquals(null, "inoff79");
		TesterHelper.println("StringHelper.checkEquals(null, \"inoff79\"); " + br);
		TesterHelper.printLineSeparator();

	}

	private static void test31() {
		String txt = "01234";
		Character.isWhitespace(0);
	}

	public static void testAll() {
		test30();

		test31();
	}

}
