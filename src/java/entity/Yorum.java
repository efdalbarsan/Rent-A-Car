package entity;

public class Yorum {

    private int yorumid;
    private int kullaniciid;
    private int aracid;
    private String yorum;
    private Kullanici kullanici;
    private Arac arac;

    public Yorum() {
    }

    public Yorum(int yorumid, int kullaniciid, int aracid, String yorum) {
        this.yorumid = yorumid;
        this.kullaniciid = kullaniciid;
        this.aracid = aracid;
        this.yorum = yorum;
    }

    public int getYorumid() {
        return yorumid;
    }

    public void setYorumid(int yorumid) {
        this.yorumid = yorumid;
    }

    public int getKullaniciid() {
        return kullaniciid;
    }

    public void setKullaniciid(int kullaniciid) {
        this.kullaniciid = kullaniciid;
    }

    public int getAracid() {
        return aracid;
    }

    public void setAracid(int aracid) {
        this.aracid = aracid;
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
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
        return "Yorum{" + "yorumid=" + yorumid + ", kullaniciid=" + kullaniciid + ", aracid=" + aracid + ", yorum=" + yorum + ", kullanici=" + kullanici + ", arac=" + arac + '}';
    }



}
