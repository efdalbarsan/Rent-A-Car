package controller;

import dao.KullaniciDAO;
import entity.Kullanici;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class KullaniciController implements Serializable {

    private List<Kullanici> kullaniciList;
    private KullaniciDAO kullaniciDAO;

    public KullaniciController() {
    }
    
    
    private Kullanici kullanici;

    public void updateForm(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public void clearForm() {
        this.kullanici = new Kullanici();
    }

    public String index() {
        clearForm();
        return "index";
    }

    public void deleteConfirm(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public void delete() {
        this.getKullaniciDAO().delete(this.kullanici);
        clearForm();
    }

    public void modify() {
        this.getKullaniciDAO().update(this.kullanici);
    }

    public void create() {
        this.getKullaniciDAO().create(this.kullanici);
        clearForm();
    }

    public Kullanici getKullanici() {
        if (this.kullanici == null) {
            this.kullanici = new Kullanici();
        }
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public List<Kullanici> getKullaniciList() {
        this.kullaniciList = this.getKullaniciDAO().read();
        return kullaniciList;
    }

    public void setKullaniciList(List<Kullanici> kullaniciList) {
        this.kullaniciList = kullaniciList;
    }

    public KullaniciDAO getKullaniciDAO() {
        if (this.kullaniciDAO == null) {
            this.kullaniciDAO = new KullaniciDAO();
        }
        return kullaniciDAO;
    }

    public void setKullaniciDAO(KullaniciDAO kullaniciDAO) {
        this.kullaniciDAO = kullaniciDAO;
    }
}
