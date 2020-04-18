package controller;

import dao.AracDAO;
import dao.HasarKaydiDAO;
import entity.Arac;
import entity.HasarKaydi;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class HasarKaydiController implements Serializable {

    private List<HasarKaydi> hasarKaydiList;
    private HasarKaydiDAO hasarKaydiDAO;
    private Long aracSec;
    private AracDAO aracDAO;
    private List<Arac> aracList;

    public HasarKaydiController() {
    }
    private HasarKaydi hasarKaydi;

    public void updateForm(HasarKaydi hasarKaydi) {
        this.aracSec =new Long(hasarKaydi.getAracid());
        this.hasarKaydi = hasarKaydi;
    }

    public void clearForm() {
        this.hasarKaydi = new HasarKaydi();
    }

    public String index() {
        clearForm();
        return "index";
    }

    public void deleteConfirm(HasarKaydi hasarKaydi) {
        this.hasarKaydi = hasarKaydi;
    }

    public void delete() {
        this.getHasarKaydiDAO().delete(this.hasarKaydi);
        clearForm();
    }

    public void modify() {
        this.hasarKaydi.setAracid(aracSec.intValue());
        this.getHasarKaydiDAO().update(this.hasarKaydi);
    }

    public void create() {
        this.hasarKaydi.setAracid(aracSec.intValue());
        this.getHasarKaydiDAO().create(this.hasarKaydi);
        clearForm();
    }

    public HasarKaydi getHasarKaydi() {
        if (this.hasarKaydi == null) {
            this.hasarKaydi = new HasarKaydi();
        }
        return hasarKaydi;
    }

    public void setHasarKaydi(HasarKaydi hasarKaydi) {
        this.hasarKaydi = hasarKaydi;
    }

    public List<HasarKaydi> getHasarKaydiList() {
        this.hasarKaydiList = this.getHasarKaydiDAO().read();
        return hasarKaydiList;
    }

    public void setHasarKaydiList(List<HasarKaydi> hasarKaydiList) {
        this.hasarKaydiList = hasarKaydiList;
    }

    public HasarKaydiDAO getHasarKaydiDAO() {
        if (this.hasarKaydiDAO == null) {
            this.hasarKaydiDAO = new HasarKaydiDAO();
        }
        return hasarKaydiDAO;
    }

    public void setHasarKaydiDAO(HasarKaydiDAO hasarKaydiDAO) {
        this.hasarKaydiDAO = hasarKaydiDAO;
    }

    public Long getAracSec() {
        return aracSec;
    }

    public void setAracSec(Long aracSec) {
        this.aracSec = aracSec;
    }

    public AracDAO getAracDAO() {
        if (this.aracDAO == null) {
            this.aracDAO = new AracDAO();
        }
        return aracDAO;
    }

    public List<Arac> getAracList() {
        this.aracList = this.getAracDAO().read();
        return aracList;
    }

    public void setAracList(List<Arac> aracList) {
        this.aracList = aracList;
    }

}
