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

    //get List of products by page
    public List<Product> getListByPage(List<Product> list, int start, int end) {
        ArrayList<Product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }
    
    //get List og products by name
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
}
