import hbx.helpers.StringHelper;
import helpers.TesterHelper;

public final class TestWork__StringHelper {
	private TestWork__StringHelper() {
	}

	private static void test30() {
		boolean br;

		br = StringHelper.isEmpty(null);
		TesterHelper.println("StringHelper.isEmpty(null) >>> " + br);
		br = StringHelper.isEmpty(StringHelper.empty);
		TesterHelper.println("StringHelper.isEmpty(StringHelper.empty) >>> " + br);
		br = StringHelper.isEmpty("박종명");
		TesterHelper.println("StringHelper.isEmpty(\"박종명\") >>> " + br);
		br = StringHelper.isEmpty("  ");
		TesterHelper.println("StringHelper.isEmpty(\"  \") >>> " + br);
		TesterHelper.printLineSeparator();

		br = StringHelper.isNotEmpty(null);
		TesterHelper.println("StringHelper.isNotEmpty(null) >>> " + br);
		br = StringHelper.isNotEmpty(StringHelper.empty);
		TesterHelper.println("StringHelper.isNotEmpty(StringHelper.empty) >>> " + br);
		br = StringHelper.isNotEmpty("박종명");
		TesterHelper.println("StringHelper.isNotEmpty(\"박종명\") >>> " + br);
		br = StringHelper.isNotEmpty("  ");
		TesterHelper.println("StringHelper.isNotEmpty(\"  \") >>> " + br);
		TesterHelper.printLineSeparator();

		br = StringHelper.checkEmpty(null);
		TesterHelper.println("StringHelper.checkEmpty(null) >>> " + br);
		br = StringHelper.checkEmpty(StringHelper.empty);
		TesterHelper.println("StringHelper.checkEmpty(StringHelper.empty) " + br);
		br = StringHelper.checkEmpty("박종명");
		TesterHelper.println("StringHelper.checkEmpty(\"박종명\") " + br);
		br = StringHelper.checkEmpty("  ");
		TesterHelper.println("StringHelper.checkEmpty(\"  \") " + br);
		TesterHelper.printLineSeparator();

		br = StringHelper.checkNotEmpty(null);
		TesterHelper.println("StringHelper.checkNotEmpty(null) >>> " + br);
		br = StringHelper.checkNotEmpty(StringHelper.empty);
		TesterHelper.println("StringHelper.checkNotEmpty(StringHelper.empty) >>> " + br);
		br = StringHelper.checkNotEmpty("박종명");
		TesterHelper.println("StringHelper.checkNotEmpty(\"박종명\") >>> " + br);
		br = StringHelper.checkNotEmpty("  ");
		TesterHelper.println("StringHelper.checkNotEmpty(\"  \") >>> " + br);
		TesterHelper.printLineSeparator();


		String rst;

		rst = StringHelper.padLeft("321", 5, 'x');
		TesterHelper.println("StringHelper.padLeft(\"321\", 5, 'x') >>> " + rst);
		rst = StringHelper.padLeft("abcdefg", 10, '0');
		TesterHelper.println("StringHelper.padLeft(\"abcdefg\", 10, '0') >>> " + rst);
		rst = StringHelper.padLeft("0123456789", 7, '#');
		TesterHelper.println("StringHelper.padLeft(\"0123456789\", 7, '#') >>> " + rst);
		TesterHelper.printLineSeparator();


		br = StringHelper.equals("", "");
		TesterHelper.println("01 >>> " + br);
		br = StringHelper.equals(null, null);
		TesterHelper.println("02 >>> " + br);
		br = StringHelper.equals("pook61", "pook61");
		TesterHelper.println("03 >>> " + br);
		br = StringHelper.equals("inoff79", "");
		TesterHelper.println("04 >>> " + br);
		br = StringHelper.equals(null, "inoff79");
		TesterHelper.println("05 >>> " + br);
		TesterHelper.printLineSeparator();


		br = StringHelper.checkEquals("", "");
		TesterHelper.println("01 >>> " + br);
		br = StringHelper.checkEquals(null, null);
		TesterHelper.println("02 >>> " + br);
		br = StringHelper.checkEquals("pook61", "pook61");
		TesterHelper.println("03 >>> " + br);
		br = StringHelper.checkEquals("inoff79", "");
		TesterHelper.println("04 >>> " + br);
		br = StringHelper.checkEquals(null, "inoff79");
		TesterHelper.println("05 >>> " + br);
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
