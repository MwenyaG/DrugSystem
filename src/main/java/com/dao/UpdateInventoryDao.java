package com.dao;

import java.sql.*;



public class UpdateInventoryDao {
    public void update(int qt,String guid,String prod){
        ResultSet rs=null;
        Connection conn=null;
        PreparedStatement ps=null;
        String query="update inventory set quantity=quantity+? where sid=? and pid=?";
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
            ps=conn.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ps.setInt(1,qt);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ps.setString(2,guid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ps.setString(3,prod);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            int i=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
