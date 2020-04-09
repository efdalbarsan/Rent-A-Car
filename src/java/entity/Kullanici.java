package entity;

public class Kullanici {
    private int kullaniciid;
    private String email;
    private String kullaniciadi;
    private String sifre;
    private int grupid;
    private String telefon;
    private String adres;
    private int aracid;

    public Kullanici() {
    }

    public Kullanici(int kullaniciid, String email, String kullaniciadi, String sifre, int grupid, String telefon, String adres, int aracid) {
        this.kullaniciid = kullaniciid;
        this.email = email;
        this.kullaniciadi = kullaniciadi;
        this.sifre = sifre;
        this.grupid = grupid;
        this.telefon = telefon;
        this.adres = adres;
        this.aracid = aracid;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getAracid() {
        return aracid;
    }

    public void setAracid(int aracid) {
        this.aracid = aracid;
    }

    @Override
    public String toString() {
        return "Kullanici{" + "kullaniciid=" + kullaniciid + ", email=" + email + ", kullaniciadi=" + kullaniciadi + ", sifre=" + sifre + ", grupid=" + grupid + ", telefon=" + telefon + ", adres=" + adres + ", aracid=" + aracid + '}';
    }

        
}
