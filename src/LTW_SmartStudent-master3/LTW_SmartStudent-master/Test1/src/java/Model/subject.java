/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author SONY
 */
public class subject implements Serializable{
    private String _nameSub;
    private float _cc, _th, _bt, _ki;
    private float _hsCC, _hsTH, _hsBT, _hsKI;
    private float average;
    
    public subject() {
        
    }

    public subject(String _nameSub, float _hsCC, float _cc, float _hsTH, float _th, float _hsBT, float _bt, float _hsKI, float _ki) {
        this._nameSub = _nameSub;
        this._cc = _cc;
        this._th = _th;
        this._bt = _bt;
        this._ki = _ki;
        this._hsCC = _hsCC;
        this._hsTH = _hsTH;
        this._hsBT = _hsBT;
        this._hsKI = _hsKI;
    }

    public String getNameSub() {
        return _nameSub;
    }

    public void setNameSub(String _nameSub) {
        this._nameSub = _nameSub;
    }

    public float getCc() {
        return _cc;
    }

    public void setCc(float _cc) {
        this._cc = _cc;
    }

    public float getTh() {
        return _th;
    }

    public void setTh(float _th) {
        this._th = _th;
    }

    public float getBt() {
        return _bt;
    }

    public void setBt(float _bt) {
        this._bt = _bt;
    }

    public float getKi() {
        return _ki;
    }

    public void setKi(float _ki) {
        this._ki = _ki;
    }

    public float getHsCC() {
        return _hsCC;
    }

    public void setHsCC(float _hsCC) {
        this._hsCC = _hsCC;
    }

    public float getHsTH() {
        return _hsTH;
    }

    public void setHsTH(float _hsTH) {
        this._hsTH = _hsTH;
    }

    public float getHsBT() {
        return _hsBT;
    }

    public void setHsBT(float _hsBT) {
        this._hsBT = _hsBT;
    }

    public float getHsKI() {
        return _hsKI;
    }

    public void setHsKI(float _hsKI) {
        this._hsKI = _hsKI;
    }

    @Override
    public String toString() {
        return "subject{" + "_nameSub=" + _nameSub + ", _cc=" + _cc + ", _th=" + _th + ", _bt=" + _bt + ", _ki=" + _ki + ", _hsCC=" + _hsCC + ", _hsTH=" + _hsTH + ", _hsBT=" + _hsBT + ", _hsKI=" + _hsKI + '}';
    }

    public float getAverage() {
        return formatNumber((this.getCc()*this.getHsCC() + this.getBt()*this.getHsBT() + this.getTh()*this.getHsTH() + this.getKi()*this.getHsKI()));
    }

    public void setAverage(float average) {
        this.average = (this.getCc()*this.getHsCC() + this.getBt()*this.getHsBT() + this.getTh()*this.getHsTH() + this.getKi()*this.getHsKI());
    }

    public static float formatNumber(float x){
        DecimalFormat df = new DecimalFormat("#.##"); 
        String formatted = df.format(x); 
        x = Float.parseFloat(formatted);
        return x;
    }
}
