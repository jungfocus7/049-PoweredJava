import hbxx.dataLoaders.ConfigDataLoader;

public final class TesterMain {
	private static void println(String p_msg) {
		System.out.println(p_msg);
	}

	public static void main(String[] p_args) {
//		String l_query = ConfigDataLoader.getTextContent("//query");
//		println(l_query);

		ConfigDataLoader.test();

	}



//
//	private static boolean checkStringEmpty(String str) {
//		return (str == null) || (str.isEmpty());
//	}
//
//
//	private final static List<Result2> m_result2List = new ArrayList<Result2>();
//
//	private static void PowerWork() {
//		String l_fp = "C:\\Users\\hb\\Desktop\\TMP31.txt";
//		Path l_path = Paths.get(l_fp);
//		if (Files.exists(l_path)) {
//			try {
//				String l_txtAll = Files.readString(l_path);
//				l_txtAll.replaceAll("fffdd","weqeasd");
//
////				List<String> l_lss = Files.readAllLines(l_path);
////				for (String l_ls : l_lss) {
////					if (checkStringEmpty(l_ls) == false) {
////						Result2 res = new Result2("Empty", l_ls);
////						m_result2List.add(res);
////					}
////				}
//
//				println("기능성...");
//			}
//			catch (Exception ex) {
//				println(ex.toString());
//			}
//		}
//
//	}
//
//
//	public static void main(String[] p_args) {
//		PowerWork();
//
//
//
//	}



}
