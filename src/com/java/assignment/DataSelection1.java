package com.java.assignment;

import java.sql.*;

public class DataSelection1 {
	public static void main(String[] args) {
		Connection con;
		Statement st;
		ResultSet rs;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://b00aqmpyij5jnm7ulrtz-mysql.services.clever-cloud.com:3306/b00aqmpyij5jnm7ulrtz?user=ufvlejybhhyetofz&password=h1wMEfU45FDTVfmXG75q");
			st=con.createStatement();
			rs=st.executeQuery("select appno,appdt, appnm, country, purpose from visitapplications");
			
			if(rs.next()) {
				System.out.print(rs.getInt("appno")+" | ");
				System.out.print(rs.getDate("appdt")+" | ");
				System.out.print(rs.getString("appnm")+" | ");
				System.out.print(rs.getString("country")+" | ");
				System.out.println(rs.getString("purpose"));
				while(rs.next()) {
					System.out.print(rs.getInt("appno")+" | ");
					System.out.print(rs.getDate("appdt")+" | ");
					System.out.print(rs.getString("appnm")+" | ");
					System.out.print(rs.getString("country")+" | ");
					System.out.println(rs.getString("purpose"));
				}
			}
			else {
				System.out.println("No any Data avialable in table");
			}
			con.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
