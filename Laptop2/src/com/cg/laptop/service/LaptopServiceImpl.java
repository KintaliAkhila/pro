package com.cg.laptop.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.laptop.dao.LaptopDaoImpl;
import com.cg.laptop.dao.ILaptopDao;
import com.cg.laptop.bean.CustomerBean;
import com.cg.laptop.bean.LaptopBean;
import com.cg.laptop.exception.LaptopException;
import com.cg.laptop.bean.CustomerBean;
import com.cg.laptop.dao.LaptopDaoImpl;
import com.cg.laptop.dao.ILaptopDao;
import com.cg.laptop.exception.LaptopException;


public class LaptopServiceImpl implements ILaptopService {
	
	ILaptopDao laptopdao=new LaptopDaoImpl();

	@Override
	public String addCustomer(CustomerBean customer) throws LaptopException {
		String customerSeq;
		customerSeq=laptopdao.addCustomer(customer);
		return customerSeq;
	}

	@Override
	public CustomerBean viewCustomerDetails(String customerId) throws LaptopException, ClassNotFoundException, IOException, SQLException {
		
		
		CustomerBean bean;
		String customerid=customerId;
		bean=laptopdao.viewCustomerDetails(customerid);
		return bean;
		
	}
	
	@Override
	public List viewLaptopDetails(LaptopBean laptopBean) throws LaptopException, ClassNotFoundException, IOException, SQLException {
		List<LaptopBean> li=new ArrayList<LaptopBean>();
		
		li=laptopdao.viewLaptopDetails(laptopBean);
		//System.out.println("2");
		return li;
	}
	
	@Override
	public void bookLaptop(LaptopBean laptop, CustomerBean customer) throws LaptopException
	{

	
		laptopdao.bookLaptop(laptop, customer);
		
	}


	
	public void validateCustomer(CustomerBean bean) throws LaptopException
	{
		List<String> validationErrors=new ArrayList<String>();
		if(!(isValidName(bean.getCustomerName()))) {
			validationErrors.add("\n customer name should be in alphabets and minimum 3 characters long");
		}
		
		if(!(isValidAddress(bean.getAddress())))
		{
			validationErrors.add("\n address should be greater than 5 characters");
			
		}
		
		if(!(isValidPhoneNumber(bean.getPhoneNumber())))
		{
			validationErrors.add("\n phone number should be 10 digits");
			
		}
		
		if(!(isValidAmount(bean.getLaptopAmount()))) {
			validationErrors.add("\n Amount should be a positive value");
		}
			
		if(!isValidEmail(bean.getMailId())) {
			
			validationErrors.add("Enter valid mail id");
			
		}
			
		
		
		if(!validationErrors.isEmpty()) {
			throw new LaptopException(validationErrors +"");
		}
		
	}
	
	private boolean isValidEmail(String mailId) {
		
		
			Pattern p3=Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
			Matcher emailMatcher=p3.matcher(mailId);
			return emailMatcher.matches();
			
		}
	

	private boolean isValidAmount(double laptopAmount)
	{
		return laptopAmount>0;
		
	}

	private boolean isValidPhoneNumber(String phoneNumber)
	{
		Pattern phonePattern=Pattern.compile("^[6-9]{1}[0-9]{9}");
		Matcher phoneMatcher=phonePattern.matcher(phoneNumber);
		return phoneMatcher.matches();
		
		
	}

	private boolean isValidAddress(String address)
	{
		
		return (address.length()>5);
		
	}

	private boolean isValidName(String customerName)
	{
		Pattern namePattern=Pattern.compile("^[A-Z][a-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(customerName);
		return nameMatcher.matches();
		
		
	}
	
	
	
	
	
private boolean isValidLaptop(String laptopModelNo) {
		
		String laptopModelNo1=laptopModelNo;
	
		if(laptopModelNo1.equals("DELL2356")||laptopModelNo1.equals("DELL5673")||laptopModelNo1.equals("HP6530")||laptopModelNo1.equals("HP8258")||laptopModelNo1.equals("LENOVO9832")||laptopModelNo1.equals("LENOVO4376")||laptopModelNo1.equals("ASUS1679")||laptopModelNo1.equals("ASUS1564"))
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	
	
	
/*private boolean isVaidLaptop(String laptopModelName) {
		
		String laptopModelName1=laptopModelName;
	
		if(laptopModelName1.equals("DELL VOSTRO 15")||laptopModelName1.equals("DELLInspiron")||laptopModelName1.equals("HP ENVY 13")||laptopModelName1.equals("HP Pavilion 15")||laptopModelName1.equals("Lenovo ThinkPad")||laptopModelName1.equals("Lenovo IdeaPad")||laptopModelName1.equals("Asus EeeBook")||laptopModelName1.equals("Asus vivoBook"))
		{
			return true;
		}
		else {
			return false;
		}
		
	}*/
		
	
	
	private boolean validateCustomerId(String customerId)
	{
		Pattern idPattern=Pattern.compile("[0-9]{1,4}");
		Matcher idMatcher=idPattern.matcher(customerId);
		if(idMatcher.matches())
			return true;
		else
			return false;
		
	}

	public void laptopValidation(LaptopBean laptop) throws LaptopException {
	
		List validationerror=new ArrayList();
		if(!isValidLaptop(laptop.getLaptopModelNo())) {
			
			validationerror.add("laptop not avialable");
		}
		if(!validationerror.isEmpty()) {
			
			throw new LaptopException(validationerror+"\n");
		}
		
		
		
	}

	
	
	
}


