/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import dao.KullaniciDAO;
import entity.Kullanici;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Barsan
 */
public class OturumTest {

    public Kullanici k = new Kullanici();
    public KullaniciDAO kdao = new KullaniciDAO();

    @Test
    public void OturumTest() {

        this.getK().setKullaniciadi("Efdal44");
        this.getK().setSifre("3344");
        this.getK().setEmail("efdal@barsan.net");
        this.getK().setTelefon("5388456625");
        this.getK().setAdres("Mersin");

        List<Kullanici> kList = new ArrayList();
        kList = this.getKdao().read();
        int j = kList.size();
        Kullanici klast = kList.get(j - 1);
        Assert.assertEquals(this.getK().getKullaniciadi(), klast.getKullaniciadi());
        Assert.assertEquals(this.getK().getSifre(), klast.getSifre());
        Assert.assertEquals(this.getK().getEmail(), klast.getEmail());
        Assert.assertEquals(this.getK().getTelefon(), klast.getTelefon());
        Assert.assertEquals(this.getK().getAdres(), klast.getAdres());

    }

    public Kullanici getK() {
        return k;
    }

    public void setK(Kullanici k) {
        this.k = k;
    }

    public KullaniciDAO getKdao() {
        return kdao;
    }

    public void setKdao(KullaniciDAO kdao) {
        this.kdao = kdao;
    }

}
