import java.util.ArrayList;
import java.util.List;


public final class TesterRoom31 {
	private static void println(String txt) {
		System.out.println(txt);
	}

	public static void main(String[] args) {
		/*
		String txt = """
xxxxxx
yyyyyy
zzzzzz
111111

				""".trim();


		println(txt);

		println(">>>");
		*/


//		threadTestLong31();

//		threadTestLong34();
	}




//	private static Thread _trd1;
//	private static Thread _trd2;
//	private static void threadTestLong31() {
//		_trd1 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				WorkProxy.test3();
//			}
//		});
//		_trd1.start();
//
//		_trd2 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				WorkProxy.test3();
//			}
//		});
//		_trd2.start();
//
//	}
//
//
//	private static volatile boolean _isLoop = true;
//	private static void threadTestLong34() {
//		long ln = System.currentTimeMillis();
//
//		List<Thread> lst = new ArrayList<Thread>();
//
//		Thread trd;
//		for (int i = 0; i < 5000; i++) {
//			trd = new Thread(new RunnerItem() {
//				private long _lx = System.currentTimeMillis();
//
//				@Override
//				public Object[] getProps() {
//					// TODO Auto-generated method stub
//					return null;
//				}
//
//				@Override
//				public void run() {
//					while (_isLoop) {
//						try {
//							Thread.sleep(3000);
//						}
//						catch (Exception ex) { }
//
//						long ly = System.currentTimeMillis() - _lx;
//						println("~~~> " + ly);
//						if (ly > 50000) {
//							_isLoop = false;
//							println("~~~ " + ly);
//						}
//					}
//				}
//			});
//			trd.setDaemon(true);
//			trd.start();
//
//			lst.add(trd);
//		}
//
//		for (Thread tx : lst) {
//			try {
//				tx.join();
//			}
//			catch (Exception ex) { }
//		}
//
//		ln = System.currentTimeMillis() - ln;
//
//		println("End of work... " + ln);
//	}

}

interface RunnerItem extends Runnable {
	public static final String pop = "";

	Object[] getProps();
}

//final class WorkProxy {
//	private static void workCore() {
//		try {
//			System.out.println("Start");
//			Thread.sleep(3000);
//			System.out.println("End");
//		}
//		catch (Exception ex) { }
//	}
//
//	public static synchronized void test1() {
//		workCore();
//	}
//
//	public static void test2() {
//		synchronized (WorkProxy.class) {
//			workCore();
//		}
//	}
//
//	public static void test3() {
//		workCore();
//	}
//}

