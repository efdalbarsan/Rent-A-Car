package controller;


import dao.GrupDAO;
import entity.Grup;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class GrupController implements Serializable{
    
    private Grup grup;
    private List<Grup> grupList;
    private GrupDAO grupDAO;

    public void updateForm(Grup grup) {
        this.grup = grup;
    }

    public void clearForm() {
        this.grup = new Grup();
    }

    public String index() {
        clearForm();
        return "index";
    }

    public void deleteConfirm(Grup grup) {
        this.grup = grup;
    }

    public void delete() {
        this.getGrupDAO().delete(this.grup);
        clearForm();
    }

    public void modify() {
        this.getGrupDAO().update(this.grup);
    }

    public void create() {
        this.getGrupDAO().create(this.grup);
        clearForm();
    }

    public Grup getGrup() {
        if (this.grup == null) {
            this.grup = new Grup();
        }
        return grup;
    }

    public void setGrup(Grup grup) {
        this.grup = grup;
    }

    public List<Grup> getGrupList() {
        this.grupList = this.getGrupDAO().read();
        return grupList;
    }

    public void setGrupList(List<Grup> grupList) {
        this.grupList = grupList;
    }

    public GrupDAO getGrupDAO() {
        if (this.grupDAO == null) {
            this.grupDAO = new GrupDAO();
        }
        return grupDAO;
    }

    public void setGrupDAO(GrupDAO grupDAO) {
        this.grupDAO = grupDAO;
    }
}
