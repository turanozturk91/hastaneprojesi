package Model;

public class Doktor extends Person{
    
    private int id;
    private int poliklinikId;
   
    public Doktor(int id, String isimSoyisim, String tckn, int poliklinikId, String telefon, String adres, String cinsiyet, String dogumTarihi) {
        this.id = id;
        this.isimSoyisim = isimSoyisim;
        this.tckn = tckn;
        this.poliklinikId = poliklinikId;
        this.telefon = telefon;
        this.adres = adres;
        this.cinsiyet = cinsiyet;
        this.dogumTarihi = dogumTarihi;
    }
    
    public Doktor(){}

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

    public String getTelefon() {
        return telefon;
    }

}
