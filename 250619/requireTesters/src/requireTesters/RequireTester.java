package requireTesters;

import java.text.MessageFormat;

import hbx.dataLoaders.ConfigDataLoader;

public final class RequireTester {
	private static void println(String txt) {
		System.out.println(txt);
	}

	public static void main(String[] args) {
		println(">>>");

		if (ConfigDataLoader.load()) {
			String email = ConfigDataLoader.getAttribute("//userInfo", "email");
			String name = ConfigDataLoader.getAttribute("//userInfo", "name");
			String age = ConfigDataLoader.getAttribute("//userInfo", "age");
			String query = ConfigDataLoader.getTextContent("//query", true);
			String msg = MessageFormat.format(
					"email: {0}, name: {1}, age: {2}, query: {3}"
					, email, name, age, query);
			println(msg);
		}

	}

}
