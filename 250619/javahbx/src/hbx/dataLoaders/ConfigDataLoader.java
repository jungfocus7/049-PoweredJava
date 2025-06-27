package hbx.dataLoaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import hbx.core.Clearable;
import hbx.helpers.DebugHelper;
import hbx.helpers.SystemHelper;


public final class ConfigDataLoader implements Clearable {
	private String _cdfp;
	private Document _xdoc;
	private XPath _xpath;

	public ConfigDataLoader(String cdfp) {
		_cdfp = cdfp;
	}

	public String getConfigDataFilePath() {
		return _cdfp;
	}

	public Document getDocument() {
		return _xdoc;
	}

	public boolean checkLoaded() {
		return _xdoc != null;
	}

	public boolean load() {
		boolean br = false;

		DocumentBuilderFactory dbf;
		DocumentBuilder db;

		File file;
		InputStream ips = null;

		XPathFactory xpf;

		try {
			dbf = DocumentBuilderFactory.newDefaultInstance();
			db = dbf.newDocumentBuilder();

			file = new File(_cdfp);
			ips = new FileInputStream(file);
			_xdoc = db.parse(ips);
			_xdoc.getDocumentElement().normalize();

			xpf = XPathFactory.newDefaultInstance();
			_xpath = xpf.newXPath();

			SystemHelper.close(ips);

			br = true;
		}
		catch (Exception ex) {
			DebugHelper.println(ex.getMessage());
		}
		finally {
			SystemHelper.close(ips);
		}

		return br;
	}

	public Element findElement(String expr) {
		Element el = null;
		try {
			el = (Element)_xpath.evaluate(expr, _xdoc, XPathConstants.NODE);
		}
		catch (Exception ex) {
			DebugHelper.println(ex.getMessage());
		}

		return el;
	}

	public String getAttribute(String expr, String name) {
		String rv = null;

		Element el = findElement(expr);
		if (el != null) {
			rv = el.getAttribute(name);
		}

		return rv;
	}

	public String getTextContent(String expr, boolean bt) {
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

	@Override
	public void clear() {
		if (_cdfp != null) {
			_cdfp = null;
			_xdoc = null;
			_xpath = null;
		}
	}

}
