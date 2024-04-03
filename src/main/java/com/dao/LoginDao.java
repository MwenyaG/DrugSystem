package com.dao;

import com.dao.bean.Customer;
import com.dao.bean.Seller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;


public class LoginDao{
    ResultSet rs=null;
    Connection conn=null;
    PreparedStatement ps=null;
    public ResultSet selectCustomer(int uid){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost/drugdatabase","root","MarioBubu123");
            String query1="SELECT uid,pass from custom WHERE uid=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query1);
            preparedStatement.setString(1, String.valueOf(uid));
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet selectSeller(int sid){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost/drugdatabase","root","root");
            String query2="SELECT sid,pass from seller WHERE sid=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query2);
            preparedStatement.setString(1, String.valueOf(sid));
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
