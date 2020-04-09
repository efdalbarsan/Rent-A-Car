package controller;

import dao.RezervasyonDAO;
import entity.Rezervasyon;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class RezervasyonController implements Serializable {

    private Rezervasyon rezervasyon;
    private List<Rezervasyon> rezervasyonList;
    private RezervasyonDAO rezervasyonDAO;

    public void updateForm(Rezervasyon rezervasyon) {
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
        this.rezervasyon.setTarih(Date.valueOf(this.rezervasyon.getTempDate()));
        this.getRezervasyonDAO().update(this.rezervasyon);
    }

    public void create() {
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

}
