package controller;

import dao.MusteriDAO;
import entity.Musteri;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class MusteriController implements Serializable{
    private Musteri musteri;
    private List<Musteri> musteriList;
    private MusteriDAO musteriDAO;

    public Musteri getMusteri() {
        if( this.musteri == null)
            this.musteri = new Musteri();
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public List<Musteri> getMusteriList() {
        this.musteriList = this.getMusteriDAO().findAll();
        return musteriList;
    }

    public void setMusteriList(List<Musteri> musteriList) {
        this.musteriList = musteriList;
    }

    public MusteriDAO getMusteriDAO() {
        if( this.musteriDAO ==  null)
            this.musteriDAO = new MusteriDAO();
        return musteriDAO;
    }

    public void setMusteriDAO(MusteriDAO musteriDAO) {
        this.musteriDAO = musteriDAO;
    }
    
    
}
