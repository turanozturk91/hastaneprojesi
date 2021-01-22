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
public class Poliklinik {
    
    private int poliklinikID;
    private String poliklinikAdi;

    public Poliklinik(int poliklinikID, String poliklinikAdi) {
        this.poliklinikID = poliklinikID;
        this.poliklinikAdi = poliklinikAdi;
    }
    
    public Poliklinik(){}

    public int getPoliklinikID() {
        return poliklinikID;
    }

    public void setPoliklinikID(int poliklinikID) {
        this.poliklinikID = poliklinikID;
    }

    public String getPoliklinikAdi() {
        return poliklinikAdi;
    }

    public void setPoliklinikAdi(String poliklinikAdi) {
        this.poliklinikAdi = poliklinikAdi;
    }
    
    
    
    
}
