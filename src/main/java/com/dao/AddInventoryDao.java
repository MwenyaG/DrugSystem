package com.dao;

import com.dao.bean.Product;
import com.dao.bean.Inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class AddInventoryDao {
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
    public Product add(String guid) {
        int flag = 0;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Product product = new Product();
        java.sql.Connection conn = null;
        String query = "select p.pid,i.quantity,p.pname,p.manufacturer,p.mfg,p.exp,p.price from product p,inventory i where p.pid=i.pid and i.sid=?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/drugdatabase", "root", "lqy0930.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ps = conn.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ps.setString(1, guid);
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
                try {
                    product.setPrname(rs.getString("pname"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    product.setPrid(rs.getInt("pid"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    product.setPrmanufacturer(rs.getString("pmanufacturer"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    product.setPrmfg(rs.getString("pmfg"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    product.setPrprice(Double.valueOf(rs.getString("price")));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    product.setQuantity(rs.getString("quantity"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                product.setExp(rs.getString("exp"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (flag == 4) {
                flag = 1;
            } else {
                flag++;
            }
        }
        product.setFlag(flag);
        return product;
    }
	public static int update (Inventory u) {
		
		int status=0;
		
		try {
			
			Connection con= getConnection();
			PreparedStatement pst = con.prepareStatement("update inventory set quantity where pid=?");
			pst.setInt(1,u.getPid());
			pst.setString(2,u.getPname());
			pst.setString(3,u.getQuantity());
			pst.setString(4,u.getPrice());
			
			status=pst.executeUpdate();
			
		}catch (Exception ex) {
			
			System.out.println(ex);
		}return status;
		
	}
}
