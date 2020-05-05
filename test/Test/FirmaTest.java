/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import dao.FirmaDAO;
import entity.Firma;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Barsan
 */
public class FirmaTest {

    public Firma f = new Firma();
    public FirmaDAO firmaDAO = new FirmaDAO();

    @Test
    public void Firma() {
        this.getF().setAdi("BARSAN OTO");
        this.getF().setTelefon("05058544433");
        this.getF().setEmail("efdal@barsan.net");
        this.getF().setAdres("Firat mh. azarbeycan sk.");
        this.getFirmaDAO().create(f);
        List<Firma> fList = new ArrayList();
        fList = this.getFirmaDAO().read();
        int j = fList.size();
        Firma flast = fList.get(j - 1);
        Assert.assertEquals(this.getF().getAdi(), flast.getAdi());
        Assert.assertEquals(this.getF().getTelefon(), flast.getTelefon());
        Assert.assertEquals(this.getF().getEmail(), flast.getEmail());
        Assert.assertEquals(this.getF().getAdres(), flast.getAdres());

    }

    public Firma getF() {
        return f;
    }

    public void setF(Firma f) {
        this.f = f;
    }

    public FirmaDAO getFirmaDAO() {
        return firmaDAO;
    }

    public void setFirmaDAO(FirmaDAO firmaDAO) {
        this.firmaDAO = firmaDAO;
    }

}
