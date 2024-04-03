package com.dao;

import com.dao.bean.Customer;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class HomeDao{
    public Customer selectCustomer(String guid){
        ResultSet rs = null;
        PreparedStatement ps = null;
        java.sql.Connection conn = null;
        Customer customer = new Customer();
        List<Customer> list = new ArrayList<Customer>();
        String query = "select fname,uid,address,phno,email from custom where uid=?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/drugdatabase", "root", "MarioBubu123");
            ps = conn.prepareStatement(query);
            ps.setString(1, guid);
            rs = ((PreparedStatement) ps).executeQuery();
            while (rs.next()) {
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("address"));
                customer.setFname(rs.getString("fname"));
                customer.setUid(Integer.parseInt(rs.getString("uid")));
                customer.setPhno(rs.getString("phno"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        finally {
            try {
                assert ps != null;
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                assert rs != null;
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return customer;
    }
}

