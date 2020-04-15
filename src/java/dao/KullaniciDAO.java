package dao;

import entity.Kullanici;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KullaniciDAO extends Dao {
    private GrupDAO grupDAO;
    
    @Override
    public List read() {
        List<Kullanici> clist = new ArrayList();

        try {
            Statement st = this.getConn().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from kullanici"); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                Kullanici tmp;
                tmp = new Kullanici(rs.getInt("kullaniciid"), rs.getString("email"), rs.getString("kullaniciadi"), rs.getString("sifre"), rs.getInt("grupid"), rs.getString("telefon"), rs.getString("adres"));

                tmp.setGrup(this.getGrupDAO().find(rs.getInt("grupid")));
                clist.add(tmp);//Her yeni kullanicii listeme ekliyorum

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clist;
    }
        public Kullanici find(int kullaniciid) {
        Kullanici k = null;

        try {
            Statement st = this.getConn().createStatement();    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from kullanici where kullaniciid=" + kullaniciid); //executeQuery veritabanindan veri cekme islemini yapar. 
            rs.next();

            k = new Kullanici();
            k.setKullaniciid(rs.getInt("kullaniciid"));
            k.setEmail(rs.getString("email"));
            k.setKullaniciadi(rs.getString("sifre"));
            k.setGrupid(rs.getInt("grupid"));
            k.setTelefon(rs.getString("telefon"));
            k.setAdres(rs.getString("adres"));


        } catch (SQLException ex) {
            System.out.println("ex.getMessage");
        }
        return k;
    }

    @Override
    public void create(Object obj) {
        Kullanici kullanici = (Kullanici) obj;
        String q = "insert into kullanici(email,kullaniciadi,sifre,grupid,telefon,adres) values (?,?,?,?,?,?)";
        try {
            PreparedStatement st = this.getConn().prepareStatement(q);
            st.setString(1, kullanici.getEmail());
            st.setString(2, kullanici.getKullaniciadi());
            st.setString(3, kullanici.getSifre());
            st.setInt(4, kullanici.getGrupid());
            st.setString(5, kullanici.getTelefon());
            st.setString(6, kullanici.getAdres());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Object obj) {
        Kullanici kullanici = (Kullanici) obj;
        String q = "delete from kullanici where kullaniciid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setInt(1, kullanici.getKullaniciid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update(Object obj) {
        Kullanici kullanici = (Kullanici) obj;
        String q = "update kullanici set email=?,kullaniciadi=?,sifre=?,grupid=?,telefon=?,adres=? where kullaniciid = ?";
        System.out.println(kullanici.toString());
        try {
            PreparedStatement st = this.getConn().prepareStatement(q);
            st.setString(1, kullanici.getEmail());
            st.setString(2, kullanici.getKullaniciadi());
            st.setString(3, kullanici.getSifre());
            st.setInt(4, kullanici.getGrupid());
            st.setString(5, kullanici.getTelefon());
            st.setString(6, kullanici.getAdres());
            st.setInt(7, kullanici.getKullaniciid());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public GrupDAO getGrupDAO() {
        if(grupDAO == null){
            this.grupDAO = new GrupDAO();
        }
        return grupDAO;
    }
    

}
