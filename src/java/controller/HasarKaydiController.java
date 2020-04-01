package controller;

import dao.HasarKaydiDAO;
import entity.HasarKaydi;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class HasarKaydiController implements Serializable{
    private HasarKaydi hasarKaydi;
    private List<HasarKaydi> hasarKaydiList;
    private HasarKaydiDAO hasarKaydiDAO;
    
   public void updateForm(HasarKaydi hasarKaydi) {
        this.hasarKaydi = hasarKaydi;
    }

    public void clearForm() {
        this.hasarKaydi = new HasarKaydi();        
    }
    public String index(){
        clearForm();
        return "index";
    }
   
    public void deleteConfirm(HasarKaydi hasarKaydi) {
        this.hasarKaydi = hasarKaydi;
    }

    public void delete() {
        this.getHasarKaydiDAO().delete(this.hasarKaydi);
        this.hasarKaydi = new HasarKaydi();
    }

    public void modify() {
        this.getHasarKaydiDAO().update(this.hasarKaydi);
        this.clearForm();
    }

    public void create() {
        this.getHasarKaydiDAO().insert(this.hasarKaydi);
        this.hasarKaydi = new HasarKaydi();
    }


    public HasarKaydi getHasarKaydi() {
        if( this.hasarKaydi == null)
            this.hasarKaydi = new HasarKaydi();
        return hasarKaydi;
    }

    public void setHasarKaydi(HasarKaydi hasarKaydi) {
        this.hasarKaydi = hasarKaydi;
    }

    public List<HasarKaydi> getHasarKaydiList() {
        this.hasarKaydiList = this.getHasarKaydiDAO().getHasarKaydi();
        return hasarKaydiList;
    }

    public void setHasarKaydiList(List<HasarKaydi> hasarKaydiList) {
        this.hasarKaydiList = hasarKaydiList;
    }

    public HasarKaydiDAO getHasarKaydiDAO() {
        if( this.hasarKaydiDAO ==  null)
            this.hasarKaydiDAO = new HasarKaydiDAO();
        return hasarKaydiDAO;
    }

    public void setHasarKaydiDAO(HasarKaydiDAO hasarKaydiDAO) {
        this.hasarKaydiDAO = hasarKaydiDAO;
    }
    
}
