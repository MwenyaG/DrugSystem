package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import com.dao.bean.Seller;

public class SellerDao {
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
	
	public static int save(Seller s) {
		int status=0;
		
        try {
			
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("insert into seller (name,phno,address,sid,pass) values (?,?,?,?,?)");
			
			
			pst.setString(1,s.getName());
			pst.setString(2,s.getPhno());
			pst.setString(3,s.getAddress());
			pst.setInt(4,s.getSid());
			pst.setString(5,s.getPass());
			
			
			status=pst.executeUpdate();
			
		}catch (Exception ex) {
			
			System.out.println(ex);
		}return status;
	}
	
	public static int getLogin(Seller s){
		int status=0;
		
		try {
			Connection con=getConnection();
			PreparedStatement pst = con.prepareStatement("select * from seller where sid=? and pass=?");
			pst.setInt(1,s.getSid());
			pst.setString(2,s.getPass());
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
		
		Seller c=null;
		
		try {
			Connection con=getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT sid from seller WHERE email=?");
			pst.setString(1,email);
			ResultSet rs = pst.executeQuery();
			c= new Seller();
			while(rs.next()) {
			c.setSid(rs.getInt("sid"));	
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return c.getSid();
	}
	
public static List<Seller> getAllRecord(){
		
		List<Seller> list = new ArrayList<Seller>();
		
		try {
			Connection con=getConnection();
			PreparedStatement pst = con.prepareStatement("select * from seller");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Seller c = new Seller();
				c.setSid(rs.getInt("sid"));
				
				c.setPass(rs.getString("pass"));
				c.setName(rs.getString("name"));
				
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

