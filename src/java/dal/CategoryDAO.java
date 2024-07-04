/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Trần Ngọc Huyền
 */
public class CategoryDAO extends DBContext {
    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Category order by name asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Category c = new Category(rs.getLong(1), rs.getString(2));
                list.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
