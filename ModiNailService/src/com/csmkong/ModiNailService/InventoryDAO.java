package com.csmkong.ModiNailService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class InventoryDAO {
	private DataSource dataSource;

	public InventoryDAO() {
		try {
		Context context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mssql");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void getItem(){
		
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			String query = "SELECT * FROM inventory";
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int sid = resultSet.getInt("sid");
				int item = resultSet.getInt("sid");
				System.out.println(sid+" : "+item);
				
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(connection != null ) connection.close();
				if(statement != null ) statement.close();
				if(resultSet != null ) resultSet.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
