package com.java.assignment;

import java.util.*;
import java.sql.*;

public class DataSearching1 {
	public static void main(String[] args) {
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		
		Scanner sc = new Scanner(System.in);
		String country;
		
		try {
			System.out.println("Enter Country Name : ");
			country=sc.nextLine();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://b00aqmpyij5jnm7ulrtz-mysql.services.clever-cloud.com:3306/b00aqmpyij5jnm7ulrtz?user=ufvlejybhhyetofz&password=h1wMEfU45FDTVfmXG75q");
			pst=con.prepareStatement("select * from visitapplications where country=?");
			pst.setString(1, country);
			rs=pst.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt("appno")+" | "+rs.getDate("appdt")+" | "+rs.getString("appnm")+" | "+rs.getString("country"));
				while(rs.next()) {
					System.out.println(rs.getInt("appno")+" | "+rs.getDate("appdt")+" | "+rs.getString("appnm")+" | "+rs.getString("country"));
				}
			}
			else {
				System.out.println("No any Application from "+country);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
