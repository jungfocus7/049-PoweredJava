package hbx.utils;

import java.io.PrintWriter;


public final class CommonHelper {
	
	public static boolean fileWriteFromText(String txt) {
		boolean br = false;
		
		PrintWriter out = null;
		try {
			out = new PrintWriter("filename.txt");
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
