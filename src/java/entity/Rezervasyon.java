package entity;

import java.sql.Date;

public class Rezervasyon {
    private int rezervasyonid;
    private int aracid;
    private int musteriid;
    private String aciklama;
    private Date tarih;
    private String tempDate;

    public Rezervasyon() {
    }

    public Rezervasyon(int rezervasyonid, int aracid, int musteriid, String aciklama, Date tarih) {
        this.rezervasyonid = rezervasyonid;
        this.aracid = aracid;
        this.musteriid = musteriid;
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

    public int getMusteriid() {
        return musteriid;
    }

    public void setMusteriid(int musteriid) {
        this.musteriid = musteriid;
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

    @Override
    public String toString() {
        return "Rezervasyon{" + "rez nervasyonid=" + rezervasyonid + ", aracid=" + aracid + ", musteriid=" + musteriid + ", aciklama=" + aciklama + ", tarih=" + tarih + '}';
    }
    
    
}
