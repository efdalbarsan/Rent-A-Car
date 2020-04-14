package entity;

public class Grup {

    private int grupid;
    private String grupadi;

    public Grup() {
    }

    public Grup(int grupid, String grupadi) {
        this.grupid = grupid;
        this.grupadi = grupadi;
    }

    public int getGrupid() {
        return grupid;
    }

    public void setGrupid(int grupid) {
        this.grupid = grupid;
    }

    public String getGrupadi() {
        return grupadi;
    }

    public void setGrupadi(String grupadi) {
        this.grupadi = grupadi;
    }

    
    @Override
    public String toString() {
        return "Grup{" + "grupid=" + grupid + ", grupadi=" + grupadi + '}';
    }


}
