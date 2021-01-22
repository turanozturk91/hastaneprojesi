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
public class Hasta extends Person{
    


    public Hasta(String isimSoyisim, String tckn, String telefon, String Adres, String Cinsiyet, String dogumTarihi) {
        this.isimSoyisim = isimSoyisim;
        this.tckn = tckn;
        this.telefon = telefon;
        this.adres = Adres;
        this.cinsiyet = Cinsiyet;
        this.dogumTarihi = dogumTarihi;
    }

    
    
    public Hasta(){ }
    
  
    
}
