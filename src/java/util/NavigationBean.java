package util;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Barsan
 */
@Named
@RequestScoped
public class NavigationBean implements Serializable{
    public String page(String p){
        return "/module/"+p+"/"+p+"?faces-redirct=true";
    }
}
