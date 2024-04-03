package com.dao;

import java.sql.*;


public class AddProductDao {
    public String add(String prid, String prname, String mfname, String guid, String price, String quantity){
        String query1="select pid from product where pid=?";
        String query2="insert into product(pid,pname,manufacturer,quantity,price) values (?,?,?,?,?)";
        String query3="insert into inventory(pid,pname,sid,quantity) values (?,?,?,?)";

        ResultSet rs=null;
        Connection conn=null;
        PreparedStatement ps1=null;
        PreparedStatement ps2=null;
        PreparedStatement ps3=null;
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
            ps1=conn.prepareStatement(query1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ps1.setString(1,prid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            rs=ps1.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if(!rs.next())
            {
                ps2=conn.prepareStatement(query2);
                ps2.setString(1,prid);
                ps2.setString(2,prname);
                ps2.setString(3,mfname);

                ps2.setInt(6, Integer.parseInt(price));
                int i=ps2.executeUpdate();
                ps3=conn.prepareStatement(query3);
                ps3.setString(1,prid);
                ps3.setString(2,prname);
                ps3.setString(3,guid);
                ps3.setInt(4, Integer.parseInt(quantity));
                int j=ps3.executeUpdate();
                return "AddInventory.jsp";
            }
            else
            {
                return "AddProductError.html";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
