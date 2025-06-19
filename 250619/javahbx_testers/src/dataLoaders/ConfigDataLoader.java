package dataLoaders;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public final class ConfigDataLoader {
	private static void println(String p_txt) {
		System.out.println(p_txt);
	}

	private final static String s_cdfp = ".\\ConfigData.xml";
	private static Document s_xdoc;
	private static XPath s_xpath;

	public static boolean checkLoaded() {
		return s_xdoc != null;
	}

	public static boolean load() {
		boolean l_br = false;
		try {
			DocumentBuilderFactory l_dbf = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder l_db = l_dbf.newDocumentBuilder();

			File l_file = new File(s_cdfp);
			s_xdoc = l_db.parse(l_file);
			s_xdoc.getDocumentElement().normalize();

			XPathFactory l_xpf = XPathFactory.newDefaultInstance();
			s_xpath = l_xpf.newXPath();

			l_br = true;
		}
		catch (Exception ex) {
			println(ex.getMessage());
		}

		return l_br;
	}

	public static Element findElement(String p_expr) {
		Element l_el = null;
		try {
			l_el = (Element)s_xpath.evaluate(p_expr, s_xdoc, XPathConstants.NODE);
		}
		catch (Exception ex) {
			println(ex.getMessage());
		}

		return l_el;
	}

	//
	//
	//
	//
	//
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static String getUserEmail() {
		String l_rv = null;

		Element l_el = findElement("//userInfo");
		if (l_el != null) {
			l_rv = l_el.getAttribute("email");
		}

		return l_rv;
	}

	public static String getUserName() {
		String l_rv = null;

		Element l_el = findElement("//userInfo");
		if (l_el != null) {
			l_rv = l_el.getAttribute("name");
		}

		return l_rv;
	}

	public static String getUserAge() {
		String l_rv = null;

		Element l_el = findElement("//userInfo");
		if (l_el != null) {
			l_rv = l_el.getAttribute("age");
		}

		return l_rv;
	}

	public static String getQuery() {
		String l_rv = null;

		Element l_el = findElement("//query");
		if (l_el != null) {
			l_rv = l_el.getTextContent().trim();
		}

		return l_rv;
	}






//	public static Element get_userInfo() {
//		Element l_el = findElement("//userInfo");
//
//		return l_el;
//	}

//	public static String get_userName() {
//		String l_rv = null;
//		try {
//			l_rv = s_xpath.evaluate("//userInfo/@name", s_xdoc);
////			Element l_el = (Element)s_xpath.evaluate("//userInfo", s_xdoc, XPathConstants.NODE);
////			l_rs = l_el.getAttribute("name");
//		}
//		catch (Exception ex) {
//			println(ex.getMessage());
//		}
//
////		Element l_el = s_xdoc.getElementById("userInfo");
////		return l_el.getAttribute("name");
//		return l_rv;
//	}

}
