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

    private List<Grup> grupList;
    private GrupDAO grupDAO;
    
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
        this.pageCount = (int) Math.ceil(this.getGrupDAO().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public GrupController() {
    }
          
    private Grup grup;

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
        this.grupList = this.getGrupDAO().read(page, pageSize);
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
