package com.sdet34l1.genericUtlity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.mysql.cj.jdbc.Driver;

/**
 * This class is used to get/set the data from database
 * @author LAVA KUMAR
 *
 */
public class MySqlUtility {
	static Driver driver;
	static Connection connection;
	static Statement statement;
	/**
	 * This method is used to open the data from DataBase and get connection
	 * @param dbUrl
	 * @param dbUserName
	 * @param dbPassword
	 * @throws SQLException
	 */
	public static void openDataFromDatabaseConnection(String dbUrl,String dbUserName,String dbPassword) throws SQLException
	{
		driver=new Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		statement=connection.createStatement();		
	}
	/**
	 * This method is used to close the database
	 * @throws SQLException
	 */
	public static void closeDataBase() throws SQLException
	{
		connection.close();
	}
	/**
	 * This method is used to get the data from data base
	 * @param query
	 * @param columnName
	 * @throws SQLException
	 */
	public static ArrayList<String> getDataFromDataBase(String query,String columnName) throws SQLException
	{
		ArrayList<String> list=new ArrayList<>();
		ResultSet result=statement.executeQuery(query);
		while(result.next())
		{
			list.add(result.getString(columnName));
		}
		return list;
	}
	/**
	 * This method is used to set the data into database
	 * @param inputQuery
	 * @throws SQLException
	 */
	public static void setDataIntoDataBase(String inputQuery) throws SQLException
	{
		int result=statement.executeUpdate(inputQuery);
		if(result>=1)
		{
			System.out.println("data insert in database successfully");
		}
	}
	/**
	 * This method is to validate the data in database
	 * @param query
	 * @param columnName
	 * @param actualData
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public static boolean validateDataInDatabase(String query,String columnName,String expectedData ) throws SQLException
	{
		ArrayList<String> list=getDataFromDataBase(query, columnName);	
		boolean flag=false;
		for(String actualData1:list)
		{
			if(actualData1.equalsIgnoreCase(expectedData))
			{
				flag=true;
				System.out.println("Tc pass");
				break;
			}
		}
		return flag;	
	}
}
