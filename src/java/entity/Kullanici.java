package entity;

public class Kullanici {
    private int kullaniciid;
    private String email;
    private String kullaniciadi;
    private String sifre;
    private int grupid;

    public Kullanici() {
    }

    public Kullanici(int kullaniciid, String email, String kullaniciadi, String sifre, int grupid) {
        this.kullaniciid = kullaniciid;
        this.email = email;
        this.kullaniciadi = kullaniciadi;
        this.sifre = sifre;
        this.grupid = grupid;
    }

    public int getKullaniciid() {
        return kullaniciid;
    }

    public void setKullaniciid(int kullaniciid) {
        this.kullaniciid = kullaniciid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKullaniciadi() {
        return kullaniciadi;
    }

    public void setKullaniciadi(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public int getGrupid() {
        return grupid;
    }

    public void setGrupid(int grupid) {
        this.grupid = grupid;
    }

    @Override
    public String toString() {
        return "Kullanici{" + "kullaniciid=" + kullaniciid + ", email=" + email + ", kullaniciadi=" + kullaniciadi + ", sifre=" + sifre + ", grupid=" + grupid + '}';
    }
    
    
}
