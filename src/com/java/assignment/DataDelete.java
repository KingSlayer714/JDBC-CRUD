package com.java.assignment;

import java.util.*;
import java.sql.*;

public class DataDelete {
	public static void main(String[] args) {
		Connection con;
		Statement st;
		PreparedStatement pst;
		ResultSet sr;
		
		int appno,r;
		Scanner sc =new Scanner(System.in);
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://b00aqmpyij5jnm7ulrtz-mysql.services.clever-cloud.com:3306/b00aqmpyij5jnm7ulrtz?user=ufvlejybhhyetofz&password=h1wMEfU45FDTVfmXG75q");
			st=con.createStatement();
			sr=st.executeQuery("select appno,appnm,purpose from visitapplications");
			while(sr.next()) {
				System.out.print(sr.getInt("appno")+" | ");
				System.out.print(sr.getString("appnm")+" | ");
				System.out.println(sr.getString("purpose"));
			}
			
			System.out.println("Enter application number from above applications to delete : ");
			appno=sc.nextInt();
			
			pst=con.prepareStatement("delete from visitapplications where appno=?");
			pst.setInt(1, appno);
			r=pst.executeUpdate();
			
			if(r>0) {
				System.out.println("Application deleted successfully...");
			}
			else {
				System.out.println("No any application deleted...");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
