//import java.io.PrintWriter;
//import java.util.SortedMap;
//import java.util.TreeMap;

//import hbx.utils.CommonHelper;
//import hbx.utils.UserInfo;

import focus.servers.TestServerList;

public final class MainProgram {

	private final static TestServerList servers = new TestServerList();

	private static void println(String txt) {
		System.out.println(txt);
	}

	private static void openTestServerGate() {
		for (int i = 0; i < 3000; i++) {
			servers.createAndStart("박종명");
			servers.createAndStart("임헌진");
			servers.createAndStart("이중호");
		}

//		TestServer server = new TestServer();
//		server.start();

//		Thread.ofPlatform();

		println(">>> 다단계");
	}

	public static void main(String[] args) {
//		BaseVirtualThread xx;

//		openTestServerGate();

//		fn_tester2();
	}

//	private static void _println(String txt) {
//		System.out.println(txt);
//	}
//
//
//	private static void fn_tester2() {
//		UserInfo um = new UserInfo("pook61@naver.com", "박종명", "p12p16");
//
//		if (um.checkLogin()) {
//			String txt = um.get_info();
//			_println(txt);
//		}
//		else {
//			_println("login faild");
//		}
//
//	}

//	private static void fn_tester1(String[] args) {
//		System.out.println("Main Started ~~~~");
//
//		if (args.length == 1) {
//			System.out.println("	~~~~ 1");
//		}
//		else if (args.length == 2) {
//			System.out.println("	~~~~ 2");
//		}
//		else if (args.length == 3) {
//			System.out.println("	~~~~ 3");
//		}
//		else if (args.length == 4) {
//			System.out.println("	~~~~ 4");
//		}
//
//
//
//		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
//		map.put("박종명", 300);
//		map.put("임헌진", 200);
//		map.put("정희범", 100);
//
//
//
////		int val = map.get("정희범");
////		map.entry
//
//
//		String txt = "개발자 네트워크 서비스 입니다.";
//
////		PrintWriter out = null;
////		try {
////			out = new PrintWriter("filename.txt");
////			out.println(txt);
////		}
////		catch (Exception ex) {
////
////		}
////		finally {
////			if (out != null) {
////				out.close();
////			}
////		}
//
//		CommonHelper.fileWriteFromText(txt);
//	}

}
