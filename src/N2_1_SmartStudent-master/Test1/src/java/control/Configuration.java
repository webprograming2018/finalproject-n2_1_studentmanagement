/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuongThanh
 */
public class Configuration {

    private Connection conn;

    public Connection getConnetion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager_student", "root", "");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return conn;
    }
}
