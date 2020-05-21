/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import dao.YorumDAO;
import entity.Yorum;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Barsan
 */
public class YorumTest {

    public Yorum yr = new Yorum();
    public YorumDAO ydao = new YorumDAO();

    @Test
    public void YorumTest() {
        this.getYr().setYorum("Memnun Kaldim");
        this.getYr().setKullaniciid(1);
        this.getYr().setAracid(3);
        this.getYdao().create(yr);
        List<Yorum> yList = new ArrayList();
        yList = this.getYdao().read();
        int j = yList.size();
        Yorum ylast = yList.get(j - 1);
        Assert.assertEquals(this.getYr().getYorum(), ylast.getYorum());
        Assert.assertEquals(this.getYr().getKullaniciid(), ylast.getKullaniciid());
        Assert.assertEquals(this.getYr().getAracid(), ylast.getAracid());

    }

    public Yorum getYr() {
        return yr;
    }

    public void setYr(Yorum yr) {
        this.yr = yr;
    }

    public YorumDAO getYdao() {
        return ydao;
    }

    public void setYdao(YorumDAO ydao) {
        this.ydao = ydao;
    }

}
