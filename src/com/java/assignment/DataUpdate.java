package com.java.assignment;

import java.util.*;
import java.sql.*;

public class DataUpdate {
	public static void main(String[] args) {
		Connection con;
		Statement st;
		PreparedStatement pst;
		ResultSet rs;
		ResultSet sr;
		
		int appno,r;
		String status;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://b00aqmpyij5jnm7ulrtz-mysql.services.clever-cloud.com:3306/b00aqmpyij5jnm7ulrtz?user=ufvlejybhhyetofz&password=h1wMEfU45FDTVfmXG75q");
			st=con.createStatement();
			sr=st.executeQuery("select appno,appnm,appstatus from visitapplications");
			while(sr.next()) {
				System.out.print(sr.getInt("appno")+" | ");
				System.out.print(sr.getString("appnm")+" | ");
				System.out.println(sr.getString("appstatus"));
			}
			
			System.out.println("Enter application number from above applications to update status : ");
			appno=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter new status out of(pending/processing/approved/rejected) for selected application : ");
			status=sc.nextLine();
			
			pst=con.prepareStatement("update visitapplications set appstatus=? where appno=?");
			pst.setString(1, status);
			pst.setInt(2, appno);
			r=pst.executeUpdate();
			
			if(r>0) {
				System.out.println("Data updated successfully...");
				pst=con.prepareStatement("select * from visitapplications where appno=?");
				pst.setInt(1, appno);
				rs=pst.executeQuery();
				System.out.println("-------Update Report-------");
				while(rs.next()){
					System.out.println(rs.getInt("appno")+" | "+rs.getString("appnm")+" | "+rs.getString("appstatus"));
				}
			}
			else {
				System.out.println("No any data updated...");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
