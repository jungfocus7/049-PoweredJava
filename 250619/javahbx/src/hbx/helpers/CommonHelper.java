package hbx.helpers;

import java.io.PrintWriter;


public final class CommonHelper {
	public static boolean writeAllText(String filePath, String txt) {
		boolean br = false;

		PrintWriter out = null;
		try {
			out = new PrintWriter(filePath);
			out.println(txt);
			br = true;
		}
		catch (Exception ex) { }
		finally {
			if (out != null) {
				out.close();
				out = null;
			}
		}

		return br;
	}
}
