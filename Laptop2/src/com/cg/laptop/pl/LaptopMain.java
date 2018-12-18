package com.cg.laptop.pl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.cg.laptop.bean.CustomerBean;
import com.cg.laptop.bean.LaptopBean;
import com.cg.laptop.exception.LaptopException;
import com.cg.laptop.service.LaptopServiceImpl;
import com.cg.laptop.service.ILaptopService;

public class LaptopMain {
	static Scanner sc=new Scanner(System.in);
	static LaptopServiceImpl laptopServiceImpl=null;
	static ILaptopService laptopService=null;
	static Logger logger = Logger.getRootLogger();
	
	public static void main(String[] args) {
		
		CustomerBean customerBean=null;
		LaptopBean laptop=null;
		String customerId=null;
		int option=0;
		while(true)
		{
			System.out.println();
			System.out.println();
			System.out.println("Customer Details");
			System.out.println("------------------------\n");
			//System.out.println("1.Add Customer");
			System.out.println("1.View Customer");
			System.out.println("2.View Laptop Details");
			System.out.println("3.Book laptop");
			System.out.println("4.Exit");
			System.out.println("-----------------------");
			System.out.println("select an option");
			
			try 
			{
				option=sc.nextInt();
				switch(option) {
				/*case 1:
					while(customerBean==null) 
					{
						customerBean=populateCustomerBean();
					}
					
					try 
					{
						laptopService=new LaptopServiceImpl();
						customerId=laptopService.addCustomer(customerBean);
						System.out.println("customer details have been successfully added");
						System.out.println("customer id :"+customerId);
					}
					
					catch(LaptopException laptopException) 
					{
						System.err.println("Error:"+laptopException.getMessage());
					}
					finally
					{
						customerId=null;
						laptopService=null;
						customerBean=null;
					}
					break;*/
				
				case 1:
					System.out.println("Enter the customer id:");
					customerId=sc.next();
					
					try
					{
						customerBean=new CustomerBean();
						laptopService=new LaptopServiceImpl();
						laptopServiceImpl=new LaptopServiceImpl();
						System.out.println(laptopService.viewCustomerDetails(customerId));
						
					}
					catch(LaptopException laptopException) {
						
						System.err.println("Error:"+laptopException.getMessage());
						logger.error("exception occured ", laptopException);
						
					}
					break;
				
				case 2:
					System.out.println("details are:");
					try
					{
						
						laptopServiceImpl=new LaptopServiceImpl();
					    List<LaptopBean> li=new ArrayList<LaptopBean>();
						li=laptopServiceImpl.viewLaptopDetails(laptop);
					
						System.out.println("\n"+li+"\n");
					}
					catch(LaptopException laptopException) {
						
						System.err.println("Error:"+laptopException.getMessage());
						logger.error("exception occured ", laptopException);
					}
					break;
				
				case 3:
					
					while(customerBean==null)
					{
					customerBean=populateCustomerBean();
					}
					while(laptop==null)
					{
					laptop=LaptopMain.laptops();
					}
					
					try {
						laptopServiceImpl=new LaptopServiceImpl();
						laptopServiceImpl.bookLaptop(laptop,customerBean);
						System.out.println("laptop is booked successfully");
					} 
					catch (Exception e) 
					{
						
						e.printStackTrace();
						logger.error("exception occured ", e);
					}
					break;
					
					
					
				case 4: System.out.println("Exit LaptopBooking Application");
				        System.exit(0);
				        break;
				        
				        
				        
					default:
						break;
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
				logger.error("exception occured ", e);
			}
		}
	}

	private static LaptopBean laptops() {
		
		LaptopBean laptop=new LaptopBean();
		System.out.println("Enter laptop details:");
		System.out.println();
		/*System.out.println("Enter laptop Model Name");
		laptop.setLaptopModelName(sc.next());*/
		System.out.println("Enter laptop Model No");
		laptop.setLaptopModelNo(sc.next());
		try
		{
			laptopServiceImpl.laptopValidation(laptop);
			return laptop;
		}
		catch(LaptopException e) {
			
			e.printStackTrace();
			logger.error("exception occured ", e);
		}
		
		
		return null;
	}

	private static CustomerBean populateCustomerBean() {
		
		CustomerBean customerBean=new CustomerBean();
		System.out.println("enter the details");
		
		System.out.println("Enter the customer name");
		customerBean.setCustomerName(sc.next());
		
		System.out.println("Enter customer contact");
		customerBean.setPhoneNumber(sc.next());
		
		System.out.println("Enter customer address");
		customerBean.setAddress(sc.next());
		
		System.out.println("Enter customer email");
		customerBean.setMailId(sc.next());
		
		
		System.out.println("Enter laptop amount");
		
		try 
		{
			customerBean.setLaptopAmount(sc.nextFloat());
		}
		
		catch(InputMismatchException ime)
		{
			sc.nextLine();
			System.out.println("please enter a numeric value for laptop amount");
		}
		
		laptopServiceImpl =new LaptopServiceImpl(); 
		
		try
		{
			laptopServiceImpl.validateCustomer(customerBean);
			
		}
		
		catch(LaptopException laptopException)
		{
			System.err.println("Invalid data");
			System.err.println(laptopException.getMessage() +"\n try again..");
			logger.error("exception occured ", laptopException);
			System.exit(0);
			
		}
		
		return customerBean;
	}

}
