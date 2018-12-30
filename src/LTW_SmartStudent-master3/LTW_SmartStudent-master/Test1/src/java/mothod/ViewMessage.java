/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mothod;

import Model.Lesson;
import Model.Message;
import Model.week;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuongThanh
 */
public class ViewMessage {

    public ViewMessage() {
    }
    
    public ArrayList<Message> getMessageByCurrentDate(Connection con, int student_id) throws ParseException {
        ArrayList<Message> lstMessage = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM _message WHERE student_id=? AND deadline_date >= ? ");
            stmt.setInt(1, student_id);
            stmt.setString(2, new java.sql.Date(System.currentTimeMillis()+24*60*60*1000).toString());
            ResultSet result = stmt.executeQuery();
            int i=0;
            while (result.next() && i<=5) {
                Message ms = new Message();
                ms.setId(result.getInt(1));
                ms.setContent(result.getString(2));
                ms.setDeadline_date(result.getDate(3));
                ms.setStudent_id(result.getInt(4));
                lstMessage.add(ms);
                i++;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lstMessage;
    }
    
    public ArrayList<Message> getMessage(Connection con, String date1, int student_id) throws ParseException {
        ArrayList<Message> lstMessage = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM _message WHERE student_id=? AND deadline_date>= ?");
            stmt.setInt(1, student_id);
//            stmt.setString(2, date1);
            stmt.setString(2, new java.sql.Date(System.currentTimeMillis()-24*60*60*1000).toString());
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                Message ms = new Message();
                ms.setId(result.getInt(1));
                ms.setContent(result.getString(2));
                ms.setDeadline_date(result.getDate(3));
                ms.setStudent_id(result.getInt(4));
                lstMessage.add(ms);
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lstMessage;
    }
    
    public boolean insertMessage(Connection con, Message msg){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("insert into _message (content, deadline_date, student_id) values (?,?,?)");
            stmt.setString(1, msg.getContent());
            stmt.setDate(2, msg.getDeadline_date());
            stmt.setInt(3, msg.getStudent_id());
            if(stmt.executeUpdate() == 1)
                return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally {
            if(stmt != null)
                try {
                    stmt.close();
            } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
            }
        }
        return false;
    }
    
    public boolean deleteMessage(Connection con, int id_message){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM _message WHERE id = ? ");
            stmt.setInt(1, id_message);
            if(stmt.executeUpdate() == 1)
                return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally {
            if(stmt != null)
                try {
                    stmt.close();
            } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
            }
        }
        return false;
    }
}

