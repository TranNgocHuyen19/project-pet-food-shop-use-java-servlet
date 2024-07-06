/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Brand;
import model.Category;
import model.Product;

/**
 *
 * @author Trần Ngọc Huyền
 */
public class ProductDAO extends DBContext {

    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getLong(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getBoolean(8),
                        rs.getInt(9),
                        new Brand(rs.getLong(10)),
                        new Category(rs.getLong(11))
                );
                list.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    //find Product by id
    public Product getProductById(long id) {
        String sql = "select * from Product where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product p = new Product(rs.getLong(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getBoolean(8),
                        rs.getInt(9),
                        new Brand(rs.getLong(10)),
                        new Category(rs.getLong(11))
                );
                return p;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    //get List of products by page
    public List<Product> getListByPage(List<Product> list, int start, int end) {
        ArrayList<Product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    //get List of products by name
    public List<Product> getAllProductsByName(String key) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product where name like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + key + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getLong(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getBoolean(8),
                        rs.getInt(9),
                        new Brand(rs.getLong(10)),
                        new Category(rs.getLong(11))
                );
                list.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    //get list products by any criteria
    public List<Product> seachProductsByCriteria(String keyword, long[] cids, long[] bids, String sortBy, String order) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product where 1 = 1";

        //Search by keyword form search form
        if (keyword != null) {
            sql += " and name like ?";
        }

        //Search by category ids
       if(cids != null && cids.length > 0) {
           sql += " and categoryId in (";
           for (int i = 0; i < cids.length; i++) {
               sql += cids[i] + ",";
           }
           if(sql.endsWith(",")) {
               sql = sql.substring(0, sql.length() - 1);
           }
           sql += ")";
       }
       
       //Search by brand ids
       if(bids != null && bids.length > 0) {
           sql += " and brandId in (";
           for (int i = 0; i < bids.length; i++) {
               sql += bids[i] + ",";
           }
           if(sql.endsWith(",")) {
               sql = sql.substring(0, sql.length() - 1);
           }
           sql += ")";
       }
       
       //Sort
       if(sortBy.equals("price")) {
           sql += " order by (price * (100 - discount) / 100) " + order;
       } else {
           sql += " order by " + sortBy + " " + order;
       }
      
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            if (keyword != null) {
                st.setString(1, "%" + keyword + "%");
            }
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getLong(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getBoolean(8),
                        rs.getInt(9),
                        new Brand(rs.getLong(10)),
                        new Category(rs.getLong(11))
                );
                list.add(p);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }
}
