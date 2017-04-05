package com.blogdataset.core;

import javax.xml.bind.*;
import java.io.* ;
import javax.xml.transform.*;

public class covertXmlToObject {

	public static void main(String[] args) {

		 try {

			File file = new File("C:\\Users\\kruti\\Desktop\\Cloud Computing\\cloud_blogdata_test.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
			System.out.println(customer);

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }

		}
}
