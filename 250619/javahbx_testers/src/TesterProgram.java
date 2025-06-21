import java.lang.reflect.Array;
import java.text.MessageFormat;

import hbx.dataLoaders.ConfigDataLoader;
import hbx.helpers.StringHelper;


public final class TesterProgram {
	private static void println(String txt) {
		System.out.println(txt);
	}

	private static void printlineSeparator() {
		println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		println(System.lineSeparator());
	}

	private static void testStringHelper() {
		boolean br;

		br = StringHelper.isEmpty(null);
		println("StringHelper.isEmpty(null) >>> " + br);
		br = StringHelper.isEmpty(StringHelper.empty);
		println("StringHelper.isEmpty(StringHelper.empty) >>> " + br);
		br = StringHelper.isEmpty("박종명");
		println("StringHelper.isEmpty(\"박종명\") >>> " + br);
		br = StringHelper.isEmpty("  ");
		println("StringHelper.isEmpty(\"  \") >>> " + br);
		printlineSeparator();

		br = StringHelper.isNotEmpty(null);
		println("StringHelper.isNotEmpty(null) >>> " + br);
		br = StringHelper.isNotEmpty(StringHelper.empty);
		println("StringHelper.isNotEmpty(StringHelper.empty) >>> " + br);
		br = StringHelper.isNotEmpty("박종명");
		println("StringHelper.isNotEmpty(\"박종명\") >>> " + br);
		br = StringHelper.isNotEmpty("  ");
		println("StringHelper.isNotEmpty(\"  \") >>> " + br);
		printlineSeparator();

		br = StringHelper.checkEmpty(null);
		println("StringHelper.checkEmpty(null) >>> " + br);
		br = StringHelper.checkEmpty(StringHelper.empty);
		println("StringHelper.checkEmpty(StringHelper.empty) " + br);
		br = StringHelper.checkEmpty("박종명");
		println("StringHelper.checkEmpty(\"박종명\") " + br);
		br = StringHelper.checkEmpty("  ");
		println("StringHelper.checkEmpty(\"  \") " + br);
		printlineSeparator();

		br = StringHelper.checkNotEmpty(null);
		println("StringHelper.checkNotEmpty(null) >>> " + br);
		br = StringHelper.checkNotEmpty(StringHelper.empty);
		println("StringHelper.checkNotEmpty(StringHelper.empty) >>> " + br);
		br = StringHelper.checkNotEmpty("박종명");
		println("StringHelper.checkNotEmpty(\"박종명\") >>> " + br);
		br = StringHelper.checkNotEmpty("  ");
		println("StringHelper.checkNotEmpty(\"  \") >>> " + br);
		printlineSeparator();


		String rst;

		rst = StringHelper.padLeft("321", 5, 'x');
		println("StringHelper.padLeft(\"321\", 5, 'x') >>> " + rst);
		rst = StringHelper.padLeft("abcdefg", 10, '0');
		println("StringHelper.padLeft(\"abcdefg\", 10, '0') >>> " + rst);
		rst = StringHelper.padLeft("0123456789", 7, '#');
		println("StringHelper.padLeft(\"0123456789\", 7, '#') >>> " + rst);
		printlineSeparator();
	}

	private static void testConfigDataLoader() {
		ConfigDataLoader cdl = new ConfigDataLoader(".\\ConfigData.xml");
		if (cdl.load()) {
			String email = cdl.getAttribute("//userInfo", "email");
			String name = cdl.getAttribute("//userInfo", "name");
			String age = cdl.getAttribute("//userInfo", "age");
			String query = cdl.getTextContent("//query", true);
			String msg = MessageFormat.format(
					"email: {0}, name: {1}, age: {2}, query: {3}"
					, email, name, age, query);
			println(msg);
			printlineSeparator();

	//		Element l_el = XmlDataLoader.get_userInfo();
	//		println(">>>>");
		}

		cdl.clear();
	}

	public static void main(String[] args) {
		testStringHelper();

		testConfigDataLoader();


		testTemper();
	}





	private static void testTemper() {
		int l = Array.getLength(new String[] { "박종명" });
		println(">>> " + l);
	}
}


















/*
//		String str = "";
//		int tw = 3;
//		char pc = '#';
//
//		char[] cha = new char[tw];
//		int i = cha.length, j = str.length();
//		while (--i >= 0) {
//			if (--j >= 0) {
//				cha[i] = str.charAt(j);
//			}
//			else {
//				cha[i] = pc;
//			}
//		}
//
//		String rs = new String(cha);
//		println(">>> " + rs);






 */


//class UserInfo {
//	public UserInfo(String p_name) {
//		m_name = (p_name == null) ? "" : p_name;
//	}
//
//	private String m_name;
//	public String get_name( ) {
//		return m_name;
//	}
//
//
//	private static void println(String p_msg) {
//		System.out.println(p_msg);
//	}
//
//	@Override
//	public String toString() {
//		String l_msg = m_name;
//		println(l_msg);
//		return l_msg;
//	}
//
//	@Override
//	public boolean equals(Object p_obj) {
//		if ((p_obj != null) && (p_obj instanceof UserInfo)) {
//			UserInfo l_ui = (UserInfo)p_obj;
//			println("equals >>> " + l_ui.m_name);
//			return m_name.equals(l_ui.m_name);
//		}
//		else {
//			return false;
//		}
//
////		if (Objects.equals(this, p_obj)) {
////			return true;
////		}
////
////		if (p_obj instanceof UserInfo) {
////			return name.equals(((UserInfo)p_obj).name);
////		}
//
////    	boolean l_rb = Object.e super.equals(p_obj);
////    	println("equals >>> " + p_obj);
////		return super.equals(p_obj);
////		return false;
//	}

//    @Override
//    public int hashCode() {
//		int l_hc = Objects.hash(name);
//		println("hashCode >>> " + l_hc);
//		return l_hc;
//    }
//}

//public final class TesterProgram {
////	private static void println(String p_txt) {
////		System.out.println(p_txt);
////	}
////
////	public static void main(String[] p_args) {
////		/*
////		if (ConfigDataLoader.load()) {
////			String l_email = Config)DataLoader.getUserEmail();
////			String l_name = ConfigDataLoader.getUserName();
////			String l_age = ConfigDataLoader.getUserAge();
////			String l_query = ConfigDataLoader.getQuery();
////			String l_msg = MessageFormat.format(
////					"email: {0}, name: {1}, age: {2}, query: {3}",
////					l_email, l_name, l_age, l_query);
////			println(l_msg);
////
//////			Element l_el = XmlDataLoader.get_userInfo();
//////			println(">>>>");
////		}
////		*/
////
////
////
////		faceOfMap();
////	}
//
//
//
//
////	private static void faceOfMap() {
////		HashSet<UserInfo> l_hss = new HashSet<UserInfo>();
////		l_hss.add(new UserInfo("박종명"));
////		l_hss.add(new UserInfo("박종명"));
////		l_hss.add(new UserInfo("박종명"));
////
//////		String l_msg = "size: " + l_hss.size();
//////		println(l_msg);
////
////		ArrayList<UserInfo> l_users = new ArrayList<UserInfo>(l_hss);
////		println(l_users.get(0).get_name());
//////		println(l_users.get(1).get_name());
////
////		ArrayList<Integer> l_xx = new ArrayList<Integer>();
////		l_xx.add(10);
////		l_xx.add(null);
////		int l_y = CollectionHelper.get(l_xx, 1, 7);
////		println(">>> " + l_y);
////	}
//
//}
