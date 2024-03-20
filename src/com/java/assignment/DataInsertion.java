package com.java.assignment;

import java.util.*;
import java.sql.*;

public class DataInsertion {
	public static void main(String[] args) {
		Connection con;
		PreparedStatement pst;
		
		String appnm,gen,coun,purp;
		int passno,c;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter Applicant Name : ");
			appnm=sc.nextLine();
			System.out.println("Enter Applicant Gender(male/female) : ");
			gen=sc.nextLine();
			System.out.println("Enter Country Name : ");
			coun=sc.nextLine();
			System.out.println("Purpose for Applying : ");
			purp=sc.nextLine();
			System.out.println("Enter Passport Number : ");
			passno=sc.nextInt();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://b00aqmpyij5jnm7ulrtz-mysql.services.clever-cloud.com:3306/b00aqmpyij5jnm7ulrtz?user=ufvlejybhhyetofz&password=h1wMEfU45FDTVfmXG75q");
			pst=con.prepareStatement("insert into visitapplications values(0,now(),?,?,?,?,?,default)");
			pst.setString(1, appnm);
			pst.setInt(2, passno);
			pst.setString(3, gen);
			pst.setString(4, coun);
			pst.setString(5, purp);
			c=pst.executeUpdate();
			
			if(c>0){
				System.out.println("Data inserted successfully...");
			}
			else
				System.out.println("Data not inserted...");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
