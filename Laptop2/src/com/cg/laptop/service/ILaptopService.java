package com.cg.laptop.service;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

	import com.cg.laptop.bean.CustomerBean;
import com.cg.laptop.bean.LaptopBean;
import com.cg.laptop.exception.LaptopException;
	public interface ILaptopService {
	
		 public String addCustomer(CustomerBean customer)throws LaptopException;
		 public CustomerBean viewCustomerDetails(String customerId)throws LaptopException, ClassNotFoundException, IOException, SQLException;
		public List viewLaptopDetails(LaptopBean laptopBean) throws LaptopException, ClassNotFoundException, IOException, SQLException;
		public void bookLaptop(LaptopBean laptop,CustomerBean customer ) throws LaptopException;
		 
	}

	
	
	

