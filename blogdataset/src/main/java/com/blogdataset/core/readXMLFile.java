package com.blogdataset.core;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class readXMLFile {

	 public static void main(String argv[]) {

		 /*  try {

		File fXmlFile = new File("C:\\Users\\kruti\\Downloads\\blogs\\blogs\\11253.male.26.Technology.Aquarius.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);

		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		//NodeList nList = doc.getElementsByTagName("Blog");
		NodeList nList = doc.getElementsByTagName("Blog");

		
		System.out.println("----------------------------");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			System.out.println("\nCurrent Element :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

			//	System.out.println("Staff id : " + eElement.getAttribute("id"));
				System.out.println("Date : " + eElement.getElementsByTagName("date").item(0).getTextContent());
				System.out.println("Post : " + eElement.getElementsByTagName("post").item(0).getTextContent());
			//	System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
			//	System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

			}
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    */
	  }

	
}
