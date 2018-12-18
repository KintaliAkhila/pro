package com.cg.laptop.dao;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.laptop.bean.CustomerBean;
import com.cg.laptop.bean.LaptopBean;
import com.cg.laptop.exception.LaptopException;
import com.cg.laptop.util.DBConnection;


public class LaptopDaoImpl implements ILaptopDao {
	
	
    Logger logger=Logger.getRootLogger();
	public LaptopDaoImpl()
	{
	PropertyConfigurator.configure("resources//log4j.properties");
	
	}
	
	
		@Override
		public String addCustomer(CustomerBean customer) throws LaptopException {
			String customerId=null;
			int queryResult=0;
			try
			{
				
				Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=null;
				ResultSet rs=null;
				Statement st=null;
				
				
				try {
					
					//preparedStatement=connection.prepareStatement("INSERT INTO Customer_Details values(customerId_sequence.nextval,?,?,?,SYSDATE,?,?)");
					preparedStatement=connection.prepareStatement(QueryMapper.INSERT_QUERY);
							
							
					preparedStatement.setString(1, customer.getCustomerName());
					preparedStatement.setString(2, customer.getAddress());
					preparedStatement.setString(3, customer.getPhoneNumber());
					preparedStatement.setDouble(4, customer.getLaptopAmount());
					//preparedStatement.setString(5, customer.getLaptopId());
					preparedStatement.setString(6, customer.getMailId());
					//preparedStatement.setString(7, customer.getLaptopModelName());
					preparedStatement.executeUpdate();
					st=connection.createStatement();
					//rs=st.executeQuery("select max(customer_id) from Customer_Details");
					rs=st.executeQuery(QueryMapper.SELECT_MAX_QUERY);	
					
					
						while(rs.next()) {
							customerId=rs.getString(1);
			
						}
						if(queryResult==0)
						{
							logger.error("Insertion failed ");
							throw new LaptopException("Inserting customer details failed ");

						}
						else
						{
							logger.info("customer details added successfully:");
							return customerId;
						}
					
					
					
					
				}
				catch(SQLException se) {
					
					System.out.println(se);
					logger.error(se.getMessage());
				}
	             			
				
				
				
			} 
			catch (Exception e)
			{
				System.out.println(e);
			}
			return customerId;
		}
		
		
		

		@Override
		public CustomerBean viewCustomerDetails(String customerId) throws LaptopException, ClassNotFoundException, IOException, SQLException {
		
			
			Connection connection=DBConnection.getConnection();
			Statement st=connection.createStatement();
			String a=customerId;
			CustomerBean bean = new CustomerBean();
		
	            try {
	            	
	  	         
	  	         
	  	         
				//ResultSet rs=st.executeQuery("select * from Customer_Details where customer_id='"+a+"'");
				ResultSet rs=st.executeQuery(QueryMapper.SELECT_QUERY_WITH_ID);
				
				
				while(rs.next())
				{
					bean.setCustomerId(rs.getString(1));
					bean.setCustomerName(rs.getString(2));
					bean.setAddress(rs.getString(3));
					bean.setPhoneNumber(rs.getString(4));
					bean.setBookingDate(rs.getString(5));
					bean.setLaptopAmount(rs.getDouble(6));
					//bean.setLaptopId(rs.getString(7));
					bean.setMailId(rs.getString(8));

					
				}
				
				if( bean!= null)
				{
					logger.info("Record Found Successfully");
					return bean;
				}
				else
				{
					logger.info("Record Not Found Successfully");
					return null;
				}
			         
		
	        }
	               catch(Exception e) 
	               {
	            	   logger.error(e.getMessage());   
	            	   System.out.println(e);
	                }
				return bean;
		}
		
		
		
		

		@Override
		public List viewLaptopDetails(LaptopBean laptop) throws ClassNotFoundException, IOException, SQLException {
			Connection connection=DBConnection.getConnection();

            try {
            	
  	          
  	         
  	        List<LaptopBean> li=new ArrayList<LaptopBean>();
  	          
  	       Statement st=connection.createStatement();
  	        
  	       // PreparedStatement preparedStatement=connection.prepareStatement("select * from laptop");
			
			//ResultSet rs=st.executeQuery("select * from laptop");
			ResultSet rs=st.executeQuery(QueryMapper.SELECT_LAPTOP_QUERY);
			while(rs.next())
			{
			
				LaptopBean laptopBean = new LaptopBean();
				laptopBean.setLaptopModelNo(rs.getString(1));
				laptopBean.setLaptopModelName(rs.getString(2));
				laptopBean.setRAM(rs.getString(3));
				laptopBean.setOS(rs.getString(4));
				laptopBean.setScreen(rs.getString(5));
				laptopBean.setHardDisk(rs.getString(6));
				laptopBean.setCPU(rs.getString(7));
				laptopBean.setLaptopPrice(rs.getInt(8));
				laptopBean.setQuantity(rs.getInt(9));
				
				li.add(laptopBean);	
			}
		          
		          //st=connection.createStatement();
		         // st.executeQuery("SELECT * FROM Donor_Details WHERE Donor_Id=donorId");
		          
			return li;
                }
               catch(Exception e) 
               {
            	   logger.error(e.getMessage());  
            	   System.out.println(e);
                }
			return null;
			
			}
		
		
		
		

		@Override
		public void bookLaptop(LaptopBean laptop, CustomerBean customer) throws LaptopException {
			
			
			String modelno=laptop.getLaptopModelNo();
			//String laptopname=laptop.getLaptopModelName();
			System.out.println("Booking Details:");
			System.out.println("Laptop Model Number:"+modelno);
			//System.out.println("Your Booking Id:"+customer.getCustomerId());
			System.out.println("Customer Name:"+customer.getCustomerName());
			Connection connection=null;
			Statement s=null;
			try
			{
				
				
				connection=DBConnection.getConnection();
				
               /* ResultSet rs=s.executeQuery("select laptopModelNo from laptop");
				
				while(rs.next())
				{
				
					LaptopBean laptopBean = new LaptopBean();
					laptopBean.setLaptopModelNo(rs.getString(1));
					
					
				}*/
			          
				
				//PreparedStatement ps=connection.prepareStatement("INSERT INTO Customer_Details values(customerId_sequence.nextval,?,?,?,SYSDATE,?,?)");
				PreparedStatement ps=connection.prepareStatement(QueryMapper.INSERT_QUERY);
				
				
				ps.setString(1, customer.getCustomerName());
				ps.setString(2, customer.getAddress());
				ps.setString(3, customer.getPhoneNumber());
				ps.setDouble(4, customer.getLaptopAmount());
			
				ps.setString(5, customer.getMailId());
			
				//ps.setString(7,laptopname);
				ps.executeUpdate();
				
				 PreparedStatement pst=connection.prepareStatement(QueryMapper.UPDATE_QUERY);
				 pst.setString(1, modelno);
				 pst.executeUpdate();

				//s.executeUpdate("update laptop set quantity=quantity-1 where laptopModelNo='"+modelno+"'");
				//s.executeUpdate(QueryMapper.UPDATE_QUERY);
				
			          //st=connection.createStatement();
			         // st.executeQuery("SELECT * FROM Donor_Details WHERE Donor_Id=donorId");
			          
			
				
				
				
				
				
				
				connection.close();
				}
				
				catch(Exception e)
				{
					logger.error(e.getMessage());
					System.out.println(e);
				}
			
			
			
			
			
		}

		

	}

	
	
	


