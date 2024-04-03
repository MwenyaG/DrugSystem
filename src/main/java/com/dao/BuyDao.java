package com.dao;

import com.dao.bean.Product;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class BuyDao {
    public Product buyProduct() {
        int flag = 0;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Product product = new Product();
        java.sql.Connection conn = null;
        String query = "select p.prname,p.prid,p.prmanufacturer,p.prmfg,p.prprice,i.quantity from product p,inventory i where p.prid=i.prid";
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
            ps = conn.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            rs = ps.executeQuery();
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
                product.setPrname(rs.getString("prname"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                product.setPrid(rs.getInt("prid"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                product.setPrmanufacturer(rs.getString("prmanufacturer"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                product.setPrmfg(rs.getString("prmfg"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                product.setPrprice(Double.valueOf(rs.getString("prprice")));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                product.setQuantity(rs.getString("quantity"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (flag == 4) {
                flag = 1;
            } else {
                flag++;
            }
            product.setFlag(flag);
        }
        return product;
    }
}
