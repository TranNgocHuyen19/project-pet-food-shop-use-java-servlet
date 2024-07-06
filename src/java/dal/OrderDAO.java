/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import model.Cart;
import model.CartItem;
import model.User;
/**
 *
 * @author Trần Ngọc Huyền
 */
public class OrderDAO extends DBContext {
    public void addOrder(User u, Cart c){
        try {
            String sql = "insert [Order] values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getFullName());
            st.setString(2, u.getPhone());
            st.setString(3, u.getEmail());
            st.setString(4, u.getAddress());
            st.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            st.setDouble(6, c.getTotalMoney());
            st.setBoolean(7, false);
            st.setBoolean(8, true);
            st.setLong(9, u.getId());
            st.executeUpdate();
            
            String sql1 = "select top 1 id from [Order] order by id desc";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs1 = st1.executeQuery();
            if(rs1.next()) {
                long oid = rs1.getLong(1);
                for (CartItem i : c.getItems()) {
                    String sql2 = "insert [OrderDetail] values (?, ?, ?, ?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setDouble(1, i.getPrice());
                    st2.setInt(2, i.getQuantity());
                    st2.setLong(3, oid);
                    st2.setLong(4, i.getProduct().getId());
                    st2.executeUpdate();
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
