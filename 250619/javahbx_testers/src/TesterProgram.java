public final class TesterProgram {
	private static void println(String txt) {
		System.out.println(txt);
	}

	public static void main(String[] args) {
		String str = "";
		int tw = 3;
		char pc = '#';

		char[] cha = new char[tw];
		int i = cha.length, j = str.length();
		while (--i >= 0) {
			if (--j >= 0) {
				cha[i] = str.charAt(j);
			}
			else {
				cha[i] = pc;
			}
		}

		String rs = new String(cha);
		println(">>> " + rs);
	}
}

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
