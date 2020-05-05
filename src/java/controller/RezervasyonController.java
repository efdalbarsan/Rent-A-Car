package controller;

import dao.AracDAO;
import dao.KullaniciDAO;
import dao.RezervasyonDAO;
import entity.Arac;
import entity.Kullanici;
import entity.Rezervasyon;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class RezervasyonController implements Serializable {

    private List<Rezervasyon> rezervasyonList;
    private RezervasyonDAO rezervasyonDAO;
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
       if(this.page == this.getPageCount()){
        this.page = 1;
       }else
           this.page++;
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        }else 
            this.page--;
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
        this.pageCount = (int) Math.ceil(this.getRezervasyonDAO().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
   
    public RezervasyonController() {
    }

    private Rezervasyon rezervasyon;

    public void updateForm(Rezervasyon rezervasyon) {
        this.AracSec =new Long(rezervasyon.getAracid());
        this.KullaniciSec =new Long(rezervasyon.getKullaniciid());
        this.rezervasyon = rezervasyon;
    }

    public void clearForm() {
        this.rezervasyon = new Rezervasyon();
    }

    public String index() {
        clearForm();
        return "index";
    }

    public void deleteConfirm(Rezervasyon rezervasyon) {
        this.rezervasyon = rezervasyon;
    }

    public void delete() {
        this.getRezervasyonDAO().delete(this.rezervasyon);
        clearForm();
    }

    public void modify() {
        this.rezervasyon.setAracid(AracSec.intValue());
        this.rezervasyon.setKullaniciid(KullaniciSec.intValue());
        this.rezervasyon.setTarih(Date.valueOf(this.rezervasyon.getTempDate()));
        this.getRezervasyonDAO().update(this.rezervasyon);
    }

    public void create() {
        this.rezervasyon.setAracid(AracSec.intValue());
        this.rezervasyon.setKullaniciid(KullaniciSec.intValue());
        this.rezervasyon.setTarih(Date.valueOf(this.rezervasyon.getTempDate()));
        this.getRezervasyonDAO().create(this.rezervasyon);
        clearForm();
    }

    public Rezervasyon getRezervasyon() {
        if (this.rezervasyon == null) {
            this.rezervasyon = new Rezervasyon();
        }
        return rezervasyon;
    }

    public void setRezervasyon(Rezervasyon rezervasyon) {
        this.rezervasyon = rezervasyon;
    }

    public List<Rezervasyon> getRezervasyonList() {
        this.rezervasyonList = this.getRezervasyonDAO().read();
        return rezervasyonList;
    }

    public void setRezervasyonList(List<Rezervasyon> rezervasyonList) {
        this.rezervasyonList = rezervasyonList;
    }

    public RezervasyonDAO getRezervasyonDAO() {
        if (this.rezervasyonDAO == null) {
            this.rezervasyonDAO = new RezervasyonDAO();
        }
        return rezervasyonDAO;
    }

    public void setRezervasyonDAO(RezervasyonDAO rezervasyonDAO) {
        this.rezervasyonDAO = rezervasyonDAO;
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
        if(this.aracDAO == null){
            this.aracDAO = new AracDAO();
        }
        return aracDAO;
    }

    public KullaniciDAO getKullaniciDAO() {
            if(this.kullaniciDAO == null){
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
