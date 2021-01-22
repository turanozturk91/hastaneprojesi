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
public class Randevu {
    
    private int id;
    private int poliklinikId;
    private int doktorId;
    private String tarih;
    private String saat;
    private Hasta hasta;

    public Randevu(int poliklinikId, int doktorId, Hasta hasta) {
        this.poliklinikId = poliklinikId;
        this.doktorId = doktorId;
        this.hasta = hasta;
    }

    public Randevu() {
        
        hasta = new Hasta();
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    public int getPoliklinikId() {
        return poliklinikId;
    }

    public void setPoliklinikId(int poliklinikId) {
        this.poliklinikId = poliklinikId;
    }

    public int getDoktorId() {
        return doktorId;
    }

    public void setDoktorId(int doktorId) {
        this.doktorId = doktorId;
    }

    public Hasta getHasta() {
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }
    
    
    
    
}
