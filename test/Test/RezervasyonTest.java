/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import dao.RezervasyonDAO;
import entity.Rezervasyon;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Barsan
 */
public class RezervasyonTest {

    public Rezervasyon rz = new Rezervasyon();
    public RezervasyonDAO rdao = new RezervasyonDAO();

    @Test
    public void RezervasyonTest() {
        this.getRz().setAciklama("Teslim alicam");
        this.getRz().setTempDate("2020-12-12");
        this.getRz().setKullaniciid(1);
        this.getRz().setAracid(3);

        this.getRdao().create(rz);
        List<Rezervasyon> rList = new ArrayList();
        rList = this.getRdao().read();
        int j = rList.size();
        Rezervasyon rlast = rList.get(j - 1);
        Assert.assertEquals(this.getRz().getAciklama(), rlast.getAciklama());
        Assert.assertEquals(this.getRz().getAciklama(), rlast.getTempDate());
        Assert.assertEquals(this.getRz().getKullaniciid(), rlast.getKullaniciid());
        Assert.assertEquals(this.getRz().getAracid(), rlast.getAracid());

    }

    public Rezervasyon getRz() {
        return rz;
    }

    public void setRz(Rezervasyon rz) {
        this.rz = rz;
    }

    public RezervasyonDAO getRdao() {
        return rdao;
    }

    public void setRdao(RezervasyonDAO rdao) {
        this.rdao = rdao;
    }

}
