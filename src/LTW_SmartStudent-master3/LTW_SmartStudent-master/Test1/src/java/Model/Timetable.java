/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author LuongThanh
 */
public class Timetable {
    private Date start_date;
    private Date end_date;
    private String note;
    private Lesson lesson;

    public Timetable() {
    }

    public Timetable(Date start_date, Date end_date, String note, Lesson lesson) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.note = note;
        this.lesson = lesson;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
    
    
}
