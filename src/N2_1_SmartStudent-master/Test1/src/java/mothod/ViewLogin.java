/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mothod;

import Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuongThanh
 */
public class ViewLogin {

    public ViewLogin() {
    }

    public Student checkUser(Connection con, String id, String pass) {
        String query = "SELECT * FROM `_student` WHERE _user = ? and _pass = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Student s = new Student();
                s.setIdSV(rs.getInt("_idSV"));
                s.setUser(rs.getString("_user"));
                s.setPass(rs.getString("_pass"));
                s.setName(rs.getString("_name"));
                s.setPhone(rs.getString("_phone"));
                s.setEmail(rs.getString("_email"));
                s.setStatus(rs.getBoolean("_status"));
                return s;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
