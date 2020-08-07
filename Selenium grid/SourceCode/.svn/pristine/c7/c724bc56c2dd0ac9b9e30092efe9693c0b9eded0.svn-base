package common;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XMLHelper {
	public static String readDataFromXML(String file, String configData) {

		String testinput;
		String configuration = "Joomla";
		String projectPath = System.getProperty("user.dir");
		File fXmlFile = new File(projectPath + File.separator + file);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		Document doc = null;
		try {
			doc = dBuilder.parse(fXmlFile);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		XPath xPath = XPathFactory.newInstance().newXPath();
		String expression = String.format("/configurations/configuration[@tag='" + configuration + "']/" + configData);
		Node node = null;
		try {
			node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		testinput = node != null ? (node.getTextContent()) : "cannot read the test case xml file";
		return testinput;

	}
}
