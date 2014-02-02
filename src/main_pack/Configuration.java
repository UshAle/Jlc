package main_pack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class Configuration {
	
	 
	Document document;
	DocumentBuilder builder;
	XPath xPath;
	
	public Configuration(String file){
		
		 
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory
					.newInstance();	
			builder = builderFactory.newDocumentBuilder();
			document = builder.parse(new FileInputStream(file));
			xPath = XPathFactory.newInstance().newXPath();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getClassName(String com){
		try{

		String expression;
		expression = "//command[name=\"" + com + "\"]/impl";
		return (String) xPath.compile(expression).evaluate(document,
				XPathConstants.STRING);
		}catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return null;
	}
}
