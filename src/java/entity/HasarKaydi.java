package entity;


public class HasarKaydi {
    private int hasarid;
    private int aracid;
    private String boya;
    private String cizik;
    private String degisim;
    private String aciklama;
    private Arac arac;

    public HasarKaydi() {
    }

    public HasarKaydi(int hasarid, int aracid, String boya, String cizik, String degisim, String aciklama) {
        this.hasarid = hasarid;
        this.aracid = aracid;
        this.boya = boya;
        this.cizik = cizik;
        this.degisim = degisim;
        this.aciklama = aciklama;
    }

    public int getHasarid() {
        return hasarid;
    }

    public void setHasarid(int hasarid) {
        this.hasarid = hasarid;
    }

    public int getAracid() {
        return aracid;
    }

    public void setAracid(int aracid) {
        this.aracid = aracid;
    }

    public String getBoya() {
        return boya;
    }

    public void setBoya(String boya) {
        this.boya = boya;
    }

    public String getCizik() {
        return cizik;
    }

    public void setCizik(String cizik) {
        this.cizik = cizik;
    }

    public String getDegisim() {
        return degisim;
    }

    public void setDegisim(String degisim) {
        this.degisim = degisim;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Arac getArac() {
        return arac;
    }

    public void setArac(Arac arac) {
        this.arac = arac;
    }

    @Override
    public String toString() {
        return "HasarKaydi{" + "hasarid=" + hasarid + ", aracid=" + aracid + ", boya=" + boya + ", cizik=" + cizik + ", degisim=" + degisim + ", aciklama=" + aciklama + ", arac=" + arac + '}';
    }
    


}


