/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mothod;

import Model.subject;
import control.Configuration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author LuongThanh
 */
public class SearchPoint {

    public ArrayList<subject> getPointTable(Connection con, int semester, String username) throws ParseException {
        ArrayList<subject> lstPoint = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM _subject where semester=?");
            stmt.setInt(1, semester);
            ResultSet rs2 = stmt.executeQuery();
            while(rs2.next()){
                subject sub = new subject(rs2.getString(2), rs2.getFloat(3), rs2.getFloat(4), rs2.getFloat(5), rs2.getFloat(6), rs2.getFloat(7),
                                rs2.getFloat(8), rs2.getFloat(9), rs2.getFloat(10));
                lstPoint.add(sub);
            }
//            boolean check = false;
//            int student_id = 0;
//            if (result.next()) {
//                check = true;
//                student_id = result.getInt(1);
//            }
//            if (check == true) {
//                PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM _point WHERE _semester=? AND studentId=?");
//                stmt2.setInt(1, semester);
//                stmt2.setInt(2, student_id);
//                ResultSet rs = stmt.executeQuery();
////                int[] lstSubject = new int[100];
////                int i=0;
//                while (rs.next()) {
////                    lstSubject[i] = rs.getInt(3);
//                    PreparedStatement stmt3 = con.prepareStatement("SELECT * FROM _subject WHERE _idSub=?");
//                    stmt3.setInt(semester, rs.getInt(3));
//                    ResultSet rs2 = stmt3.executeQuery();
//                    while (rs2.next()) {
//                        subject sub = new subject(rs2.getString(2), rs2.getFloat(3), rs2.getFloat(4), rs2.getFloat(5), rs2.getFloat(6), rs2.getFloat(7),
//                                rs2.getFloat(8), rs2.getFloat(9), rs2.getFloat(10));
//                        lstPoint.add(sub);
//                    }
//                }
//            }
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
        return lstPoint;
    }

    public static void main(String[] args) {
        String username = "Manh";
        int semester = 1;
        try {
            Configuration config = new Configuration();
            Connection con = config.getConnetion();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM _student WHERE _user=?");
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();
            System.out.println("AAA");
            boolean check = false;
            int student_id = 0;
            if (result.next()) {
                check = true;
                student_id = result.getInt(1);
            }
            System.out.println(check);
            if (check == true) {
                PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM _point WHERE _semester=? AND studentId=?");
                stmt2.setInt(1, semester);
                stmt2.setInt(2, student_id);
                ResultSet rs = stmt.executeQuery();
//                int[] lstSubject = new int[100];
//                int i=0;
                while (rs.next()) {
//                    lstSubject[i] = rs.getInt(3);
                    student_id++;
                    System.out.println(rs.getInt(3));
                    PreparedStatement stmt3 = con.prepareStatement("SELECT * FROM _subject WHERE _idSub=?");
                    stmt3.setInt(1, rs.getInt(3));
                    ResultSet rs2 = stmt3.executeQuery();

                    while (rs2.next()) {
                        System.out.println(rs2.getString(2));
                        subject sub = new subject(rs2.getString(2), rs2.getFloat(3), rs2.getFloat(4), rs2.getFloat(5), rs2.getFloat(6), rs2.getFloat(7),
                                rs2.getFloat(8), rs2.getFloat(9), rs2.getFloat(10));
                        System.out.println(sub.toString());
                        
                    }
//                    stmt3.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
