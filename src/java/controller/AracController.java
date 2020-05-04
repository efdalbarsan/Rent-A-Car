package controller;

import dao.AracDAO;
import dao.FirmaDAO;
import entity.Arac;
import entity.Firma;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class AracController implements Serializable {

    private List<Arac> clist;
    private AracDAO adao;
    private FirmaDAO firmaDAO;
    private Long FirmaSec;
    private List<Firma> firmaList;

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
        this.pageCount = (int) Math.ceil(this.getAdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public AracController() {
    }

    private Arac arac;

    public void updateForm(Arac arac) {
        this.FirmaSec = new Long(arac.getFirmaid());
        this.arac = arac;//Guncellemek istedigimiz nesneyi araccontroller bean nin arac nesnesine atama islemini yaptik.
    }

    public void clearForm() {
        this.arac = new Arac();
    }

    public String index() {
        clearForm();
        return "index";
    }

    public void deleteConfirm(Arac arac) {
        this.arac = arac;
    }

    public void delete() {
        this.getAdao().delete(this.arac);
        clearForm();
    }

    public void modify() {
        this.arac.setFirmaid(FirmaSec.intValue());
        this.getAdao().update(this.arac);
    }

    public void create() {
        this.arac.setFirmaid(FirmaSec.intValue());
        this.getAdao().create(this.arac);
        clearForm();
    }

    public List<Arac> getClist() {
        this.clist = this.getAdao().read(page, pageSize);
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
        return this.arac;
    }

    public void setArac(Arac arac) {
        this.arac = arac;
    }

    public Long getFirmaSec() {
        return FirmaSec;
    }

    public void setFirmaSec(Long FirmaSec) {
        this.FirmaSec = FirmaSec;
    }

    public FirmaDAO getFirmaDAO() {
        if (firmaDAO == null) {
            firmaDAO = new FirmaDAO();
        }
        return firmaDAO;
    }

    public List<Firma> getFirmaList() {
        this.firmaList = this.getFirmaDAO().read();
        return firmaList;
    }

    public void setFirmaList(List<Firma> firmaList) {
        this.firmaList = firmaList;
    }

}
