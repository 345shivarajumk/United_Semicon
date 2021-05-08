package com.crm.vtiger.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con =null;
	public void getDatabaseConnection() throws Throwable {
		//step1: resister the database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);

		//step2: establish connection with database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root","root");
	}
	public void executeQuery(String query) throws Throwable {
		//step3: Issue create statement
		Statement stat = con.createStatement();

		//step4:Execute any query
		ResultSet res = stat.executeQuery(query);
		while(res.next()) {
			System.out.println(res.getString(1)+"\t"+res.getString(2));
		}	
	}
	public void executeUpdte(String query) throws Throwable {
		//step3: Issue create statement
		Statement stat = con.createStatement();

		//step4:Execute any query
		stat.executeUpdate("insert into customer value('raghvandra','raghvandra ojha','phulpur allahabad','allahabad',635647,'india')");

	}
	public void closeDatabase() throws Throwable {
		con.close();
	}
}

