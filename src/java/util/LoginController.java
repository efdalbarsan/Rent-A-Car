/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.KullaniciDAO;
import entity.Kullanici;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


/**
 *
 * @author Barsan
 */
@Named
@SessionScoped
public class LoginController implements Serializable{
    private Kullanici kullanici;
    private KullaniciDAO kdao;
    
    public String login(){
        
        if(getKdao().Login(getKullanici().getEmail(),getKullanici().getSifre()) != null){
            this.kullanici =getKdao().Login(getKullanici().getEmail(),getKullanici().getSifre());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.kullanici);
            return "/secret/panel?faces-redirect =true";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatali kullanici adi veya sifre"));
            return"/index";
        }
    }
    
    public String logout() {
        return "/faces/index.xhtml";
    }

    public Kullanici getKullanici() {
        if (kullanici == null) {
            kullanici = new Kullanici();
        }
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public KullaniciDAO getKdao() {
        if (kdao == null) {
            kdao = new KullaniciDAO();
        }
        return kdao;
    }

    public void setKdao(KullaniciDAO kdao) {
        this.kdao = kdao;
    }

   
    
    
}
