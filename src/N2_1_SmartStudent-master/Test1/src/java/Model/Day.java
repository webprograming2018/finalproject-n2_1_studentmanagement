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
public class Day implements Serializable{
    private Date _date;
    private String _nameDay;
    private week _week;

    public Day(Date _date, String _nameDay, week _week) {
        this._date = _date;
        this._nameDay = _nameDay;
        this._week = _week;
    }

    public Day() {
    }

    public Date getDate() {
        return _date;
    }

    public void setDate(Date _date) {
        this._date = _date;
    }

    public String getNameDay() {
        return _nameDay;
    }

    public void setNameDay(String _nameDay) {
        this._nameDay = _nameDay;
    }

    public week getWeek() {
        return _week;
    }

    public void setWeek(week _week) {
        this._week = _week;
    }
    
    
}
