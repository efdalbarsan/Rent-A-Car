package entity;

public class Musteri {
    private int musteriid;
    private String adi;
    private String telefon;
    private String email;
    private String adres;

    public Musteri() {
    }

    public Musteri(int musteriid, String adi, String telefon, String email, String adres) {
        this.musteriid = musteriid;
        this.adi = adi;
        this.telefon = telefon;
        this.email = email;
        this.adres = adres;
    }


    public int getMusteriid() {
        return musteriid;
    }

    public void setMusteriid(int musteriid) {
        this.musteriid = musteriid;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
    
    
}
