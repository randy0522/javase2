package xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by randy on 2018/12/1.
 */
public class Test {
	public static void main(String[] args) throws IOException,
			SAXException,
			ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		ClassLoader classLoader = Test.class.getClassLoader();
		InputStream ins = classLoader.getResourceAsStream("test.xml");
		Document document = documentBuilder.parse(ins);
		NodeList nodes = document.getElementsByTagName("randy");
		System.out.println("node length:" + nodes.getLength());
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);

			if (node instanceof Element) {
				node = (Element) nodes;
			}
		}
	}
}
