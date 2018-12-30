/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import mothod.ViewMessage;
import Model.Message;
import Model.Student;
import control.Configuration;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import mothod.ViewLogin;

/**
 *
 * @author LuongThanh
 */
public class Check1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager_student", "root", "");
//
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from _lesson");
//            while (rs.next()) {
//                System.out.println(rs.getInt(1));
//            }
//            conn.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Configuration con = new Configuration();
        ViewMessage v = new ViewMessage();
        java.sql.Date d = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 365);
        System.out.println(v.deleteMessage(con.getConnetion(), 7));
//        System.out.println("");
        String date = "31-12-2019";
        java.util.Date sdf1;
        if (date.indexOf("-") == 2) {
            sdf1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        } else {
            sdf1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        }
        java.sql.Date dd = new java.sql.Date(sdf1.getTime());
        ArrayList<Message> s = v.getMessage(con.getConnetion(),dd.toString() , 1);
        for (Message i : s) {
            System.out.println(i.toString());
        }
        Message msg = new Message();
        msg.setContent("444");
        msg.setDeadline_date(new java.sql.Date(System.currentTimeMillis()));
        msg.setStudent_id(1);
//        System.out.println(v.insertMessage(con.getConnetion(), msg));
    }
}
