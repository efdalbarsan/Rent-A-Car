/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Document;
import entity.Gorsel;

/**
 *
 * @author Barsan
 */
public class GorselIslem implements Gorsel {

    private Gorsel gorsel;
    private String GorselIsmi;

    public GorselIslem(String GorselIsmi) {
        this.GorselIsmi = GorselIsmi;
    }

    @Override
    public void setGorsel(Gorsel gorsel) {
        this.GorselIsmi = GorselIsmi;
    }

    @Override
    public void time(Document document) {
        if (document.getFileType().equals("image/jpg")) {
            System.out.println("foto yüklendi" + GorselIsmi);
        } else if (gorsel != null) {
            System.out.println(GorselIsmi + "istek gönderildi" + gorsel.getGorsel());
        } else {
            System.out.println("Dosya desteklenmedi");
        }
    }

    @Override
    public String getGorsel() {
        return GorselIsmi;
    }
}
