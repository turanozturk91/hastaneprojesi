/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author turanozturk
 */
public class Calisan {
    
    private int id;
    private String isim;
    private String soyisim;
    private String tckn;
    private int tip;

    public Calisan(String isim, String soyisim, String tckn, int tip) {
        this.id = id;
        this.isim = isim;
        this.soyisim = soyisim;
        this.tckn = tckn;
        this.tip = tip;
    }
    
    public Calisan(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getTckn() {
        return tckn;
    }

    public void setTckn(String tckn) {
        this.tckn = tckn;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }
    
    
}
