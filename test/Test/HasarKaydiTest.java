/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import dao.HasarKaydiDAO;
import entity.HasarKaydi;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Barsan
 */
public class HasarKaydiTest {

    public HasarKaydi hk = new HasarKaydi();
    public HasarKaydiDAO hasarKaydiDAO = new HasarKaydiDAO();

    @Test
    public void HasarKaydi() {
        this.getHk().setBoya("var");
        this.getHk().setCizik("yok");
        this.getHk().setDegisim("yok");
        this.getHk().setAciklama("var");
        this.getHasarKaydiDAO().create(hk);
        List<HasarKaydi> hkList = new ArrayList();
        hkList = this.getHasarKaydiDAO().read();
        int j = hkList.size();
        HasarKaydi hklast = hkList.get(j - 1);
        Assert.assertEquals(this.getHk().getBoya(), hklast.getBoya());
        Assert.assertEquals(this.getHk().getCizik(), hklast.getCizik());
        Assert.assertEquals(this.getHk().getDegisim(), hklast.getDegisim());
        Assert.assertEquals(this.getHk().getAciklama(), hklast.getAciklama());

    }

    public HasarKaydi getHk() {
        return hk;
    }

    public void setHk(HasarKaydi hk) {
        this.hk = hk;
    }

    public HasarKaydiDAO getHasarKaydiDAO() {
        return hasarKaydiDAO;
    }

    public void setHasarKaydiDAO(HasarKaydiDAO hasarKaydiDAO) {
        this.hasarKaydiDAO = hasarKaydiDAO;
    }

}
