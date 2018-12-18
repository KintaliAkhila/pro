package com.cg.laptop.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.cg.laptop.dao.LaptopDaoImpl;
import com.cg.laptop.util.DBConnection;

class DBConnectionTest {
	
	static LaptopDaoImpl dao;
	static Connection con;
	
	@BeforeClass
	public void initialize() {
		
		dao=new LaptopDaoImpl();
		con=null;
		
	}
	
	@Before
	public void beforeEachTest() {
		
		System.out.println("----Starting DBConnection Test Case----\\n");
	}
	

	@Test
	public void test() throws ClassNotFoundException, IOException, SQLException {
		Connection dbCon = DBConnection.getConnection();
		Assert.assertNotNull(dbCon);
	}
	
	@After
	public void afterEachTest() {
		
		System.out.println("----End of DBConnection Test Case----\\n");
	}
	
	@AfterClass
	public void destroy() {
		
		System.out.println("\\t----End of Tests----");
		dao=null;
		con=null;
	}

}
