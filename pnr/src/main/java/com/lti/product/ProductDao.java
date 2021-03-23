package com.lti.product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;
public class ProductDao {
	public void insert(Product product) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@ DESKTOP-C0BGK5S:1522:XE", "system", "nikhil");
			String sql = "insert into tbl_product values(?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, product.getId());
			stmt.setString(2, product.getName());
			stmt.setDouble(3, product.getPrice());
			stmt.setInt(4, product.getQuantity());
			stmt.executeUpdate();
			

			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try { conn.close();} catch (Exception e) {}
		}
		
		
	}
}
