/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import dao.AracDAO;
import entity.Arac;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Barsan
 */
public class AracTest {

    public Arac ar = new Arac();
    public AracDAO adao = new AracDAO();

    @Test
    public void AracTest() {
        this.getAr().setPlaka("54 rte 8405");
        this.getAr().setMarka("Volkswagene");
        this.getAr().setModel("Amorok");
        this.getAr().setMotor(2.4);
        this.getAr().setYil(2015);
        this.getAr().setKilometre(14590);
        this.getAr().setYakit("dizel");
        this.getAr().setVites("yari otomatik");
        this.getAr().setFiyat(245);
        this.getAdao().create(ar);
        List<Arac> aList = new ArrayList();
        aList = this.getAdao().read();
        int j = aList.size();
        Arac alast = aList.get(j - 1);
        Assert.assertEquals(this.getAr().getPlaka(), alast.getPlaka());
        Assert.assertEquals(this.getAr().getMarka(), alast.getMarka());
        Assert.assertEquals(this.getAr().getModel(), alast.getModel());
        Assert.assertEquals(this.getAr().getMotor(), alast.getMotor());
        Assert.assertEquals(this.getAr().getYil(), alast.getYil());
        Assert.assertEquals(this.getAr().getKilometre(), alast.getKilometre());
        Assert.assertEquals(this.getAr().getYakit(), alast.getYakit());
        Assert.assertEquals(this.getAr().getVites(), alast.getVites());
        Assert.assertEquals(this.getAr().getFiyat(), alast.getFiyat());

    }

    public Arac getAr() {
        return ar;
    }

    public void setAr(Arac ar) {
        this.ar = ar;
    }

    public AracDAO getAdao() {
        return adao;
    }

    public void setAdao(AracDAO adao) {
        this.adao = adao;
    }
}
