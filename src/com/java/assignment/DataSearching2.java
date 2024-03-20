package com.java.assignment;

import java.util.*;
import java.sql.*;

public class DataSearching2 {
	public static void main(String[] args) {
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		Scanner sc=new Scanner(System.in);
		String status;
		
		try {
			System.out.println("Enter application status out of(pending/processing/approved/rejected) : ");
			status=sc.nextLine();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://b00aqmpyij5jnm7ulrtz-mysql.services.clever-cloud.com:3306/b00aqmpyij5jnm7ulrtz?user=ufvlejybhhyetofz&password=h1wMEfU45FDTVfmXG75q");
			pst=con.prepareStatement("select * from visitapplications where appstatus=?");
			pst.setString(1, status);
			rs=pst.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt("appno")+" | "+rs.getString("appnm")+" | "+rs.getString("appstatus"));
				while(rs.next()) {
					System.out.println(rs.getInt("appno")+" | "+rs.getString("appnm")+" | "+rs.getString("appstatus"));
				}
			}
			else {
				System.out.println("No any application having status "+status);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
