/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Brand;
/**
 *
 * @author Trần Ngọc Huyền
 */
public class BrandDAO extends DBContext {
    public List<Brand> getAll() {
        List<Brand> list = new ArrayList<>();
        String sql = "select * from Brand order by name asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Brand b = new Brand(rs.getLong(1), rs.getString(2));
                list.add(b);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
