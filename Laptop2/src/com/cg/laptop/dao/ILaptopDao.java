package com.cg.laptop.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cg.laptop.bean.CustomerBean;
import com.cg.laptop.bean.LaptopBean;
import com.cg.laptop.exception.LaptopException;

public interface ILaptopDao {

		
		 public String addCustomer(CustomerBean customer)throws LaptopException;
		 public CustomerBean viewCustomerDetails(String customerId)throws LaptopException, ClassNotFoundException, IOException, SQLException;
		public List viewLaptopDetails(LaptopBean laptop) throws ClassNotFoundException, IOException, SQLException;
		public void bookLaptop(LaptopBean laptop,CustomerBean customer ) throws LaptopException;
	}

	
	
	

