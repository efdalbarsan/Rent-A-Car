package entity;

public class Yorum {
    private int yorumid;
    private int musteriid;
    private int aracid;
    private String yorum;

    public Yorum() {
    }

    public Yorum(int yorumid, int musteriid, int aracid, String yorum) {
        this.yorumid = yorumid;
        this.musteriid = musteriid;
        this.aracid = aracid;
        this.yorum = yorum;
    }

    public int getYorumid() {
        return yorumid;
    }

    public void setYorumid(int yorumid) {
        this.yorumid = yorumid;
    }

    public int getMusteriid() {
        return musteriid;
    }

    public void setMusteriid(int musteriid) {
        this.musteriid = musteriid;
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

    @Override
    public String toString() {
        return "Yorum{" + "yorumid=" + yorumid + ", musteriid=" + musteriid + ", aracid=" + aracid + ", yorum=" + yorum + '}';
    }
    
    
}
