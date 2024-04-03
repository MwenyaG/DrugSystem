package com.dao;

import com.dao.bean.Product;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class OrdersDao {
    public Product orders(String gid) throws SQLException {
        int flag=0;
        ResultSet rs=null;
        CallableStatement cs=null;
        Product product = new Product();
        java.sql.Connection conn=null;
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
            cs = conn.prepareCall("call getorders(?)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        cs.setString(1, String.valueOf(gid));
        rs = cs.executeQuery();
      
        while (rs.next()) {
            product.setOid(rs.getInt("oid"));
            product.setPrid(rs.getInt("pid"));
            product.setPrprice(rs.getDouble("price"));
            product.setQuantity(rs.getString("quantity"));
            product.setSid(rs.getInt("sid"));
            product.setOrderdatetime(rs.getTime("orderdatetime"));
        }
        return product;
    }
}
