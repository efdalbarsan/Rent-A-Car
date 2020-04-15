package controller;

import dao.YorumDAO;
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

    public YorumController() {
    }
      
    private Yorum yorum;

    public void updateForm(Yorum yorum) {
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
        this.getYorumDAO().update(this.yorum);
    }

    public void create() {
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
}
