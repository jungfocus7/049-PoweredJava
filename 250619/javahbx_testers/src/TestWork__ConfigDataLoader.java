import java.text.MessageFormat;

import hbx.dataLoaders.ConfigDataLoader;
import helpers.TesterHelper;

public final class TestWork__ConfigDataLoader {
	private TestWork__ConfigDataLoader() {
	}

	private static void test30() {
		ConfigDataLoader cdl = new ConfigDataLoader(".\\ConfigData.xml");
		if (cdl.load()) {
			String email = cdl.getAttribute("//userInfo", "email");
			String name = cdl.getAttribute("//userInfo", "name");
			String age = cdl.getAttribute("//userInfo", "age");
			String query = cdl.getTextContent("//query", true);
			String msg = MessageFormat.format(
					"email: {0}, name: {1}, age: {2}, query: {3}"
					, email, name, age, query);
			TesterHelper.println(msg);
			TesterHelper.printLineSeparator();
		}

		cdl.clear();
	}

	private static void test31() {
	}

	public static void testAll() {
		test30();

		test31();
	}

}
