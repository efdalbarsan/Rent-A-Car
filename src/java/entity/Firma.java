package entity;

public class Firma {
    private int firmaid;
    private String adi;
    private String telefon;
    private String eamil;
    private String adres;
    
    private Firma firma;

    public Firma() {
    }

    public Firma(int firmaid, String adi, String telefon, String eamil, String adres, Firma firma) {
        this.firmaid = firmaid;
        this.adi = adi;
        this.telefon = telefon;
        this.eamil = eamil;
        this.adres = adres;
        this.firma = firma;
    }

  

    public int getFirmaid() {
        return firmaid;
    }

    public void setFirmaid(int firmaid) {
        this.firmaid = firmaid;
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

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
    
    
}
