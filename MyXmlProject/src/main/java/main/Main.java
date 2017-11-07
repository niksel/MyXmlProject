package main;
import java.io.*;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import JAXB.Address;
import JAXB.Customer;
import JAXB.PaymentMethod;

public class Main {

	public static void main(String[] args) throws JAXBException, DatatypeConfigurationException {
		// TODO Auto-generated method stub
		marshellingUnmarshell();
		
	}
	
	public static void marshellingUnmarshell() throws JAXBException, DatatypeConfigurationException {
		File file = new File("customerXML.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		Customer c = new Customer();
		c.setCustomerId(100);
		c.setName("Nikhil");
		c.setAnnualSalary(60000);
		c.setDateOfBirth(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
		Address address = new Address();
		address.setStreet("Heath street");
		address.setCity("Buffalo");
		address.setState("NY");
		address.setCountry("US");
		address.setZipcode("14214");
		List<Address> addresses = c.getAddresses();
		addresses.add(address);
		PaymentMethod pm = new PaymentMethod();
		pm.setCardNo("200");
		pm.setCardName("Visa");
		pm.setDateFrom(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
		pm.setCardType("VISA");
		List<PaymentMethod> pmlist = c.getPaymentMethods();
		pmlist.add(pm);
		jaxbMarshaller.marshal(c, file);
		jaxbMarshaller.marshal(c, System.out);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Customer c2 = (Customer) unmarshaller.unmarshal(file);
		System.out.println(c2);
		
		}

}
