package com.dao;

import com.dao.bean.Product;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class SellerOrdersDao {
    public Product order(String guid) {
        int flag = 0;
        ResultSet rs = null;
        CallableStatement cs = null;
        Product product = new Product();
        java.sql.Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/drugdatabase", "root", "MarioBubu123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            cs = conn.prepareCall("call getsellerorders(?)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            cs.setString(1, guid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            rs = cs.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     
        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                product.setPrid(rs.getInt("pid"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                product.setPrice(rs.getDouble("price"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                product.setQuantity(rs.getString("quantity"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                product.setUid(rs.getInt("uid"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return product;
//        return rs;
    }
}
