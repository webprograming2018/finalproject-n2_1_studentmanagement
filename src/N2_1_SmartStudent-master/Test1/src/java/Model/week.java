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
public class week implements Serializable{
    protected int _countWeek;
    protected Date _start, _end;

    public week() {
    }

    public week(int _countWeek, Date _start, Date _end) {
        this._countWeek = _countWeek;
        this._start = _start;
        this._end = _end;
    }

    public int getCountWeek() {
        return _countWeek;
    }

    public void setCountWeek(int _countWeek) {
        this._countWeek = _countWeek;
    }

    public Date getStart() {
        return _start;
    }

    public void setStart(Date _start) {
        this._start = _start;
    }

    public Date getEnd() {
        return _end;
    }

    public void setEnd(Date _end) {
        this._end = _end;
    }

    @Override
    public String toString() {
        return "Week: "+_countWeek+"--- "+_start.getTime()+" : "+_end.getTime();
    }  
    
}
