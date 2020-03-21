package controller;

import dao.AracDAO;
import entity.Arac;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class AracController implements Serializable {

    private List<Arac> clist;
    private AracDAO adao;

    public AracController() {
    }

    private Arac arac;

    public void updateForm(Arac arac) {
        this.arac = arac;//Guncellemek istedigimiz nesneyi araccontroller bean nin arac nesnesine atama islemini yaptik.
    }

    public void clearForm() {
        this.arac = new Arac();        
    }
    public String index(){
        clearForm();
        return "index";
    }
   
    public String deleteConfirm(Arac arac) {
        this.arac = arac;
        return "confirm_delete";
    }

    public String delete() {
        this.getAdao().delete(this.arac);
        this.arac = new Arac();
        return "index";
    }

    public void modify() {
        this.getAdao().update(this.arac);
    }

    public void create() {
        this.getAdao().insert(this.arac);
        clearForm();
    }

    public List<Arac> getClist() {
        this.clist = this.getAdao().getArac();
        return this.clist;
    }

    public void setClist(List<Arac> clist) {
        this.clist = clist;
    }

    public AracDAO getAdao() {
        if (this.adao == null) {
            this.adao = new AracDAO();
        }
        return adao;
    }

    public void setAdao(AracDAO adao) {
        this.adao = adao;
    }

    public Arac getArac() {
        if (this.arac == null) {
            this.arac = new Arac();
        }
        return arac;
    }

    public void setArac(Arac arac) {
        this.arac = arac;
    }

}
