package hbxx.dataLoaders;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public final class ConfigDataLoader {
	private static boolean checkStringNotEmpty(String p_str) {
		return (p_str != null) && (p_str.length() > 0);
	}

	private static void println(String p_msg) {
		System.out.println(p_msg);
	}

	private static void printDom(String p_indent, Node p_node) {
		String l_msg = p_indent + p_node.toString();
		println(l_msg);

		final String l_ind = "	";

		Node l_cnd = p_node.getFirstChild();
		while (l_cnd != null) {
			String l_plus = l_ind + l_ind;
			printDom(l_plus, l_cnd);
			l_cnd = l_cnd.getNextSibling();
		}
	}


	private static final String s_cfp = ".\\ConfigData.xml";

	private static Document s_xdoc;
	private static XPath s_xpath;

	private static void loadData() {
		try {
			DocumentBuilderFactory l_dbf = DocumentBuilderFactory.newDefaultInstance();
			l_dbf.setIgnoringComments(true);
			l_dbf.setIgnoringElementContentWhitespace(true);
			DocumentBuilder l_db = l_dbf.newDocumentBuilder();

			File l_file = new File(s_cfp);
			s_xdoc = l_db.parse(l_file);
//			s_xdoc.getDocumentElement().normalize();
//			s_xdoc.normalizeDocument();
//			println(">>>> " + s_xdoc.getClass().getName());

			XPathFactory l_xpf = XPathFactory.newDefaultInstance();
			s_xpath = l_xpf.newXPath();

			println(s_xdoc.getFirstChild().getTextContent());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	static {
		loadData();
	}

	public static Node findNode(String p_expr) {
		Node l_node = null;
		try {
			l_node = (Node)s_xpath.evaluate(p_expr, s_xdoc, XPathConstants.NODE);
//			println(">>> " + l_node.toString());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

		return l_node;
	}

	public static Element findElement(String p_expr) {
		Element l_el = null;

		Node l_node = findNode(p_expr);
		if (l_node != null) {
			if (l_node instanceof Element) {
				l_el = (Element)l_node;
			}
		}

		return l_el;
	}

	public static String getTextContent(String p_expr) {
		String l_rv = null;

		Node l_node = findNode(p_expr);
		if (l_node != null) {
			l_rv = l_node.getTextContent();
			if (checkStringNotEmpty(l_rv)) {
				l_rv = l_rv.trim();
			}
		}

		return l_rv;
	}

	public static String getNodeValue(String p_expr) {
		String l_rv = null;

		Node l_node = findNode(p_expr);
		if (l_node != null) {
			l_rv = l_node.getNodeValue();
			if (checkStringNotEmpty(l_rv)) {
				l_rv = l_rv.trim();
			}
		}

		return l_rv;
	}

	public static void test() {
		Node l_node = findNode("//query");
		printDom("	", l_node);

//		println(l_node.getNodeValue());
//		println(l_node.getTextContent());

//		l_node = findNode("//query/@name");
//		println(l_node.getNodeValue());
//		println(l_node.getTextContent());
	}

}
