package entity;

import java.sql.Date;

public class Rezervasyon {
    private int rezervasyonid;
    private int aracid;
    private int kullaniciid;
    private String aciklama;
    private Date tarih;
    private String tempDate;
    private Kullanici kullanici;
    private Arac arac;

    public Rezervasyon() {
    }

    public Rezervasyon(int rezervasyonid, int aracid, int musteriid, String aciklama, Date tarih) {
        this.rezervasyonid = rezervasyonid;
        this.aracid = aracid;
        this.kullaniciid = musteriid;
        this.aciklama = aciklama;
        this.tarih = tarih;
    }

    public String getTempDate() {
        return tempDate;
    }

    public void setTempDate(String tempDate) {
        this.tempDate = tempDate;
    }
    

    public int getRezervasyonid() {
        return rezervasyonid;
    }

    public void setRezervasyonid(int rezervasyonid) {
        this.rezervasyonid = rezervasyonid;
    }

    public int getAracid() {
        return aracid;
    }

    public void setAracid(int aracid) {
        this.aracid = aracid;
    }

    public int getKullaniciid() {
        return kullaniciid;
    }

    public void setKullaniciid(int kullaniciid) {
        this.kullaniciid = kullaniciid;
    }


    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public Arac getArac() {
        return arac;
    }

    public void setArac(Arac arac) {
        this.arac = arac;
    }

    @Override
    public String toString() {
        return "Rezervasyon{" + "rezervasyonid=" + rezervasyonid + ", aracid=" + aracid + ", kullaniciid=" + kullaniciid + ", aciklama=" + aciklama + ", tarih=" + tarih + ", tempDate=" + tempDate + ", kullanici=" + kullanici + ", arac=" + arac + '}';
    }
    

  
    


    
    
}
