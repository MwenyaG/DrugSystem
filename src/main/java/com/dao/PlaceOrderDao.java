package com.dao;

import java.sql.*;



public class PlaceOrderDao {
    public String placeOrder(String pid,String guid,int qr){
        Connection conn=null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        PreparedStatement ps2=null;
        String a,b;
        int c;
        String query1="select P.pid,O.sid,P.price from inventory o,product p where p.pid=? and p.pid=o.pid";
        String query2="insert into orders(pid,sid,uid,quantity,price) values(?,?,?,?,?)";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/drugdatabase","root","MarioBubu123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ps=conn.prepareStatement(query1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ps.setString(1,pid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            rs=ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if(rs.next())
            {
                a=rs.getString("pid");
                b=rs.getString("sid");
                c=rs.getInt("price");
                ps2=conn.prepareStatement(query2);
                ps2.setString(1,a);
                ps2.setString(2,b);
                ps2.setString(3,guid);
                ps2.setInt(4,qr);
                ps2.setInt(5,qr*c);
                int i=ps2.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Orders.jsp";
    }
}
