package controller;

import dao.AracDAO;
import dao.KullaniciDAO;
import dao.YorumDAO;
import entity.Arac;
import entity.Kullanici;
import entity.Yorum;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class YorumController implements Serializable {

    private List<Yorum> yorumList;
    private YorumDAO yorumDAO;
    private Long AracSec;
    private Long KullaniciSec;
    private AracDAO aracDAO;
    private KullaniciDAO kullaniciDAO;
    private List<Arac> aracList;
    private List<Kullanici> kullaniciList;
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getYorumDAO().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public YorumController() {
    }

    private Yorum yorum;

    public void updateForm(Yorum yorum) {
        this.AracSec = new Long(yorum.getAracid());
        this.KullaniciSec = new Long(yorum.getKullaniciid());
        this.yorum = yorum;
    }

    public void clearForm() {
        this.yorum = new Yorum();
    }

    public String index() {
        clearForm();
        return "index";
    }

    public void deleteConfirm(Yorum yorum) {
        this.yorum = yorum;
    }

    public void delete() {
        this.getYorumDAO().delete(this.yorum);
        clearForm();
    }

    public void modify() {
        this.yorum.setAracid(AracSec.intValue());
        this.yorum.setKullaniciid(KullaniciSec.intValue());
        this.getYorumDAO().update(this.yorum);
    }

    public void create() {
        this.yorum.setKullaniciid(KullaniciSec.intValue());
        this.yorum.setAracid(AracSec.intValue());
        this.getYorumDAO().create(this.yorum);
        clearForm();
    }

    public Yorum getYorum() {
        if (this.yorum == null) {
            this.yorum = new Yorum();
        }
        return yorum;
    }

    public void setYorum(Yorum yorum) {
        this.yorum = yorum;
    }

    public List<Yorum> getYorumList() {
        this.yorumList = this.getYorumDAO().read();
        return yorumList;
    }

    public void setYorumList(List<Yorum> yorumList) {
        this.yorumList = yorumList;
    }

    public YorumDAO getYorumDAO() {
        if (this.yorumDAO == null) {
            this.yorumDAO = new YorumDAO();
        }
        return yorumDAO;
    }

    public void setYorumDAO(YorumDAO yorumDAO) {
        this.yorumDAO = yorumDAO;
    }

    public Long getAracSec() {
        return AracSec;
    }

    public void setAracSec(Long AracSec) {
        this.AracSec = AracSec;
    }

    public Long getKullaniciSec() {
        return KullaniciSec;
    }

    public void setKullaniciSec(Long KullaniciSec) {
        this.KullaniciSec = KullaniciSec;
    }

    public AracDAO getAracDAO() {
        if (this.aracDAO == null) {
            this.aracDAO = new AracDAO();
        }
        return aracDAO;
    }

    public KullaniciDAO getKullaniciDAO() {
        if (this.kullaniciDAO == null) {
            kullaniciDAO = new KullaniciDAO();
        }
        return kullaniciDAO;
    }

    public List<Arac> getAracList() {
        this.aracList = this.getAracDAO().read();
        return aracList;
    }

    public void setAracList(List<Arac> aracList) {
        this.aracList = aracList;
    }

    public List<Kullanici> getKullaniciList() {
        this.kullaniciList = this.getKullaniciDAO().read();
        return kullaniciList;
    }

    public void setKullaniciList(List<Kullanici> kullaniciList) {
        this.kullaniciList = kullaniciList;
    }

}
