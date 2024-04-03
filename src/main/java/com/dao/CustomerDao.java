package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import com.dao.bean.Customer;

public class CustomerDao {
	public static Connection getConnection(){
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/drugdatabase","root","MarioBubu123");
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return con;
	}
	
	public static int save(Customer c) {
		int status=0;
		
        try {
			
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("insert into customer (fname,lname,email,phno,address,uid,pass) values (?,?,?,?,?,?,?)");
			
			
			pst.setString(1,c.getFname());
			pst.setString(2,c.getLname());
			pst.setString(3,c.getEmail());
			pst.setString(4,c.getPhno());
			pst.setString(5,c.getAddress());
			pst.setInt(6,c.getUid());
			pst.setString(7,c.getPass());
			
			status=pst.executeUpdate();
			
		}catch (Exception ex) {
			
			System.out.println(ex);
		}return status;
	}
	
	public static int getLogin(Customer c){
		int status=0;
		
		try {
			Connection con=getConnection();
			PreparedStatement pst = con.prepareStatement("select * from customer where uid=? and pass=?");
			pst.setInt(1,c.getUid());
			pst.setString(2,c.getPass());
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
			status=1;		
			}else {
			status=-1;
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return status;
	}
	
	public static int getUid(String email){
		
		Customer c=null;
		
		try {
			Connection con=getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT uid from customer WHERE email=?");
			pst.setString(1,email);
			ResultSet rs = pst.executeQuery();
			c= new Customer();
			while(rs.next()) {
			c.setUid(rs.getInt("uid"));	
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return c.getUid();
	}
	
public static List<Customer> getAllRecord(){
		
		List<Customer> list = new ArrayList<Customer>();
		
		try {
			Connection con=getConnection();
			PreparedStatement pst = con.prepareStatement("select * from customer");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Customer c = new Customer();
				c.setUid(rs.getInt("uid"));
				c.setEmail(rs.getString("email"));
				c.setPass(rs.getString("pass"));
				c.setFname(rs.getString("fname"));
				c.setLname(rs.getString("lname"));
				c.setPhno(rs.getString("phno"));
				c.setAddress(rs.getString("address"));
				
			list.add(c);		
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	
}

