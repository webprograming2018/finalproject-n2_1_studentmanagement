/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mothod;

import Model.Lesson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author LuongThanh
 */
public class ViewTimetable {
    public ArrayList<Lesson> getTimetableByWeek(Connection con, String week) throws ParseException {
        int week_id = Integer.parseInt(week);
        ArrayList<Lesson> lstLesson = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM _timetable WHERE week_num=?");
            stmt.setInt(1, week_id);
            ResultSet result = stmt.executeQuery();
            int[] lesson_id = new int[100];
            int i=0;
            while(result.next()){
                lesson_id[i] = result.getInt("lesson_id");
//                i++;
//            }
            //select lesson tuong ung voi lessong_id
            String query = ("SELECT * FROM _lesson WHERE id="+lesson_id[i]);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            while(rs.next()){
                Lesson lesson = new Lesson();
                lesson.setId(rs.getInt(1));
                lesson.setDay(rs.getString(2));
                lesson.setRoom(rs.getInt(3));
                lesson.setShift(rs.getInt(4));
                lesson.setSubject(rs.getString(5));
                lesson.setTeacher(rs.getString(6));
                lstLesson.add(lesson);
            }
            i++;
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lstLesson;
    }
    
}
