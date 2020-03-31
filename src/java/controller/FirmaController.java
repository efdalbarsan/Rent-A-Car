
package controller;

import dao.FirmaDAO;
import entity.Firma;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class FirmaController implements Serializable{
    
    private List<Firma> clist;
    private FirmaDAO firmaDAO;

    public FirmaController() {
    }

    private Firma firma;

    public void updateForm(Firma firma) {
        this.firma = firma;//Guncellemek istedigimiz nesneyi firmacontroller bean nin firma nesnesine atama islemini yaptik.
    }

    public void clearForm() {
        this.firma = new Firma();        
    }
    public String index(){
        clearForm();
        return "index";
    }
   
    public void deleteConfirm(Firma firma) {
        this.firma = firma;
    }

    public void delete() {
        this.getFirmaDAO().delete(this.firma);
        clearForm();
    }

    public void modify() {
        this.getFirmaDAO().update(this.firma);
    }

    public void create() {
        this.getFirmaDAO().insert(this.firma);
        clearForm();
    }

    public List<Firma> getClist() {
        this.clist = this.getFirmaDAO().getFirma();
        return this.clist;
    }

    public void setClist(List<Firma> clist) {
        this.clist = clist;
    }

    public FirmaDAO getFirmaDAO() {
        if (this.firmaDAO == null) {
            this.firmaDAO = new FirmaDAO();
        }
        return firmaDAO;
    }

    public void setAdao(FirmaDAO firmaDAO) {
        this.firmaDAO = firmaDAO;
    }

    public Firma getFirma() {
        if (this.firma == null) {
            this.firma = new Firma();
        }
        return this.firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

}
