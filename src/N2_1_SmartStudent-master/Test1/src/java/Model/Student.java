/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author SONY
 */
public class Student implements Serializable{
    private int _idSV;
    private String _user, _pass, _name, _phone, _email;
    private boolean _status;

    public Student() {
    }

    public Student(String _user, String _pass, String _name, String _phone, String _email) {
        this._user = _user;
        this._pass = _pass;
        this._name = _name;
        this._phone = _phone;
        this._email = _email;
        this._status = true;
    }

    public String getUser() {
        return _user;
    }

    public void setUser(String _user) {
        this._user = _user;
    }

    public String getPass() {
        return _pass;
    }

    public void setPass(String _pass) {
        this._pass = _pass;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getPhone() {
        return _phone;
    }

    public void setPhone(String _phone) {
        this._phone = _phone;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public boolean isStatus() {
        return _status;
    }

    public void setStatus(boolean _status) {
        this._status = _status;
    }

    public int getIdSV() {
        return _idSV;
    }

    public void setIdSV(int _idSV) {
        this._idSV = _idSV;
    }

    @Override
    public String toString() {
        return "[ID: "+_idSV+";user: "+_user+";name: "+_name+";status: "+_status;
    }
    
}
