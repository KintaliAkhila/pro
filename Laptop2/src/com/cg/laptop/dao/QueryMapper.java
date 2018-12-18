package com.cg.laptop.dao;

public interface QueryMapper {

	String INSERT_QUERY="INSERT INTO Customer_Details values(customerId_sequence.nextval,?,?,?,SYSDATE,?,?)";
	String SELECT_QUERY="select max(customer_id) from Customer_Details";
	String SELECT_QUERY_WITH_ID="select * from Customer_Details where customer_id=?";
	String SELECT_LAPTOP_QUERY="select * from laptop";
	String UPDATE_QUERY="update laptop set quantity=quantity-1 where laptopModelNo=?";
	String SELECT_MAX_QUERY="select max(customer_id) from Customer_Details";
	
}
