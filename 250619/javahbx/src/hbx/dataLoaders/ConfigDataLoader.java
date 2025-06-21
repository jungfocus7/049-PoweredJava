package hbx.dataLoaders;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import hbx.helpers.DebugHelper;


public final class ConfigDataLoader {
	private final static String _cdfp = ".\\ConfigData.xml";
	private static Document _xdoc;
	private static XPath _xpath;

	public static boolean checkLoaded() {
		return _xdoc != null;
	}

	public static boolean load() {
		boolean br = false;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			File file = new File(_cdfp);
			_xdoc = db.parse(file);
			_xdoc.getDocumentElement().normalize();

			XPathFactory xpf = XPathFactory.newDefaultInstance();
			_xpath = xpf.newXPath();

			br = true;
		}
		catch (Exception ex) {
			DebugHelper.println(ex.getMessage());
		}

		return br;
	}

	public static Element findElement(String expr) {
		Element el = null;
		try {
			el = (Element)_xpath.evaluate(expr, _xdoc, XPathConstants.NODE);
		}
		catch (Exception ex) {
			DebugHelper.println(ex.getMessage());
		}

		return el;
	}
	
	public static String getAttribute(String expr, String name) {
		String rv = null;

		Element el = findElement(expr);
		if (el != null) {
			rv = el.getAttribute(name);
		}

		return rv;
	}
	
	public static String getTextContent(String expr, boolean bt) {
		String rv = null;

		Element el = findElement(expr);
		if (el != null) {
			if (bt) {
				rv = el.getTextContent().trim();
			}
			else {
				rv = el.getTextContent();
			}
		}

		return rv;
	}	

}
