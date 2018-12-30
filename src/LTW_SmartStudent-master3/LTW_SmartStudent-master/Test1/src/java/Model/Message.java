/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author SONY
 */
public class Message implements Serializable, Comparable<Message>{
    private int id;
    private String content;
    private Date deadline_date;
    private int student_id;

    public Message(int id, String content, Date deadline_date, int student_id) {
        this.id = id;
        this.content = content;
        this.deadline_date = deadline_date;
        this.student_id = student_id;
    }

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDeadline_date() {
        return deadline_date;
    }

    public void setDeadline_date(Date deadline_date) {
        this.deadline_date = deadline_date;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", content=" + content + ", deadline_date=" + deadline_date + ", student_id=" + student_id + '}';
    }

    @Override
    public int compareTo(Message o) {
        return this.getDeadline_date().compareTo(o.getDeadline_date());
    }
  
}
