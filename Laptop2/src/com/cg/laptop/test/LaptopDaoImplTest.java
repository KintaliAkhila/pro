package com.cg.laptop.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.cg.laptop.bean.CustomerBean;
import com.cg.laptop.bean.LaptopBean;
import com.cg.laptop.dao.LaptopDaoImpl;
import com.cg.laptop.exception.LaptopException;

class LaptopDaoImplTest {
	
	static LaptopDaoImpl dao;
	static CustomerBean cust;
	static LaptopBean lap;

	@BeforeClass
	public static void initialize() {
		
		System.out.println("in before class");
		dao=new LaptopDaoImpl();
		cust=new CustomerBean();
		lap=new LaptopBean();
	}
	
	

	@Test
	void testAddCustomer() throws LaptopException {
		assertNotNull(dao.addCustomer(cust));
	}
	
	
	@Test
	void testBookLaptop1() throws LaptopException
	{
		
		cust.setCustomerName("Akhila");
		cust.setAddress("sholinganallur");
		cust.setMailId("akhi@gmail.com");
		cust.setPhoneNumber("9876543210");
		cust.setLaptopAmount(45552);
		cust.setLaptopId("HP6530");
		
		assertEquals("Akhila",cust.getCustomerName());
		assertEquals("sholinganallur",cust.getAddress());
		assertEquals("akhi@gmail.com",cust.getMailId());
		assertEquals("9876543210",cust.getPhoneNumber());
		assertEquals("45552",cust.getLaptopAmount());
		assertEquals("HP6530",cust.getLaptopId());
	}
	
	
	

	@Test
	void testViewCustomerDetails() throws ClassNotFoundException, LaptopException, IOException, SQLException {
		assertNotNull(dao.viewCustomerDetails("21"));
	}

	@Test
	void testViewLaptopDetails() throws ClassNotFoundException, IOException, SQLException {
		assertNotNull(dao.viewLaptopDetails(lap));
		
	}

}
