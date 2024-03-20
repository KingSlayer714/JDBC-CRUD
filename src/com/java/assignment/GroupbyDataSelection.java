package com.java.assignment;

import java.sql.*;

public class GroupbyDataSelection {
	public static void main(String[] args) {
		Connection con;
		Statement st;
		ResultSet rs;
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://b00aqmpyij5jnm7ulrtz-mysql.services.clever-cloud.com:3306/b00aqmpyij5jnm7ulrtz?user=ufvlejybhhyetofz&password=h1wMEfU45FDTVfmXG75q");
		st=con.createStatement();
		rs=st.executeQuery("select count(appno) as 'applications',appstatus from visitapplications group by appstatus");
		
		System.out.println("-------Summary Report-------");
		
		while(rs.next()) {
			System.out.println(rs.getString("appstatus")+" "+rs.getInt("applications"));
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
