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
public class Person {
    
    protected String isimSoyisim;
    protected String tckn;
    protected String telefon;
    protected String adres;
    protected String cinsiyet;
    protected String dogumTarihi;
    
    public String getisimSoyisim() {
        return isimSoyisim;
    }

    public void setisimSoyisim(String isimSoyisim) {
        this.isimSoyisim = isimSoyisim;
    }

    public String getTckn() {
        return tckn;
    }

    public void setTckn(String tckn) {
        this.tckn = tckn;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String Adres) {
        this.adres = Adres;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String Cinsiyet) {
        this.cinsiyet = Cinsiyet;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }
    
    
}
