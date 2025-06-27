import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import helpers.TesterHelper;


public final class TesterProgram {
	public static void main(String[] args) {
		TestWork__StringHelper.testAll();
//
//		TestWork__ReflectionHelper.testAll();
//
//		TestWork__ConfigDataLoader.testAll();



//		testTemper30();

//		testTemper31();

//		testTemper32();

//		testTemper33();

//		testTemper34();
	}


	private static void testTemper34() {
//		String txt = "    ";
//		String txt = "         1   ";
		String txt = """

1

				""";

		boolean bFind = false;
		for (int i = 0, l = txt.length(); i < l; i++) {
			char ch = txt.charAt(i);
			if (Character.isWhitespace(ch) == false) {
				bFind = true;
				break;
			}

//			TesterHelper.println(">>> " + Character.isWhitespace(System.lineSeparator()));
		}

		TesterHelper.println(">>> " + (bFind == false));
	}


	private static void testTemper30() {
		int l = Array.getLength(new String[] { "박종명" });
		TesterHelper.println(">>> " + l);
	}


	private static void testTemper31() {
//		String name = "박종명";
//		println("::" + "임헌진".compareTo(name));
//		println("::" + ("b".compareTo("c")));
//		if ("임헌진".compareTo(name) < 0)
//		{
//
//		}

//		String[] nums = { "2", "3", "" };
		String nums = "8012983014";
		char[] cha = nums.toCharArray();

		Arrays.sort(cha);


		List<String> lst = new ArrayList<String>();
		lst.add("03) 박종명");
		lst.add("02) 임헌진");
		lst.add("01) 이중호");
		lst.sort(new Comparator<String>() {
			@Override
			public int compare(String tx, String ty) {
				int rx = tx.compareTo(ty);
				if (rx < 0) {
					return 1;
				}
				else if (rx < 0) {
					return -1;
				}
				else {
					return 0;
				}
			}
		});


		TesterHelper.println(">>>");

	}


	private static void testTemper32() {
//		String[] nums = new String[] { "9", "8", "7", "6", "5", "4", "4", "3", "3", "1", "1", "9" };
//		ArrayList<String> nums = { "0", "1", "2", "3", "3", "2" };

//		char[] nums = "98765432109955331223777".toCharArray();
		String numStr = "98765432109955331223777";
//		Character[] nums = "98765432109955331223777".chars().mapToObj(tx -> Character.valueOf(tx)).toArray(Character[]::new);
		char[] cha = numStr.toCharArray();
		Character[] nums = new Character[cha.length];
		for (int i = 0; i < cha.length; i++) {
			nums[i] = Character.valueOf(cha[i]);
		}

		List<Character> lst = new ArrayList<Character>();
		for (char num : nums) {
			lst.add(num);
		}

		LinkedHashSet<Character> lhs = new LinkedHashSet<Character>();
		lhs.addAll(lst);

		HashSet<Character> hss = new HashSet<Character>();
		hss.addAll(lst);


//		Arrays.stream(nums).;

		TesterHelper.println(">>>");




//        char[] originalArray = {1, 2, 2, 3, 4, 4, 5};
//        char[] distinctArray = Arrays.stream(originalArray)
//                                   .distinct()
//                                   .toArray();

		Object[] objs = nums;
		Arrays.stream(objs);

	}


	private static void testTemper33() {
		/*
		String numstr = "98765432109955331223777";
		char[] nums = numstr.toCharArray();

		List<char> xx = Arrays.asList(nums);

		Character[] cha = new Character[cha.length];
		for (int i = 0; i < cha.length; i++) {
			nums[i] = Character.valueOf(cha[i]);
		}



		List<Character> lst = new ArrayList<Character>();
		for (char num : nums) {
			lst.add(num);
		}

		LinkedHashSet<Character> lhs = new LinkedHashSet<Character>();
		lhs.addAll(lst);

		HashSet<Character> hss = new HashSet<Character>();
		hss.addAll(lst);


//		Arrays.stream(nums).;

		println(">>>");
		*/




//        char[] originalArray = {1, 2, 2, 3, 4, 4, 5};
//        char[] distinctArray = Arrays.stream(originalArray)
//                                   .distinct()
//                                   .toArray();

//		Object[] objs = nums;
//		Arrays.stream(objs);

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
