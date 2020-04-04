package dao;

import entity.Kullanici;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class KullaniciDAO {

    private DBConnection connection;
    private Connection c;

    public List<Kullanici> getKullanici() {
        List<Kullanici> clist = new ArrayList();

        try {
            Statement st = this.getC().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from kullanici"); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                Kullanici tmp;
                tmp = new Kullanici(rs.getInt("kullaniciid"), rs.getString("email"), rs.getString("kullaniciadi"), rs.getString("sifre"), rs.getInt("grupid"));

                clist.add(tmp);//Her yeni kullanicii listeme ekliyorum

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clist;
    }

    public void insert(Kullanici kullanici) {
        String q = "insert into kullanici(email,kullaniciadi,sifre,grupid) values (?,?,?,?)";
        try {
            PreparedStatement st = this.getC().prepareStatement(q);
            st.setString(1, kullanici.getEmail());
            st.setString(2, kullanici.getKullaniciadi());
            st.setString(3, kullanici.getSifre());
            st.setInt(4, kullanici.getGrupid());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Kullanici kullanici) {
        String q = "delete from kullanici where kullaniciid = ?";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setInt(1, kullanici.getKullaniciid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Kullanici kullanici) {
        String q = "update kullanici set email=?, kullaniciadi=?, sifre=?, grupid=? where kullaniciid = ?";
        System.out.println(kullanici.toString());
        try {
            PreparedStatement st = this.getC().prepareStatement(q);
            st.setString(1, kullanici.getEmail());
            st.setString(2, kullanici.getKullaniciadi());
            st.setString(3, kullanici.getSifre());
            st.setInt(4, kullanici.getGrupid());
            st.setInt(5, kullanici.getKullaniciid());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public DBConnection getConnection() {
        if (this.connection == null) {
            this.connection = new DBConnection();
        }
        return connection;
    }

    public Connection getC() {
        if (this.c == null) {
            this.c = getConnection().connect();
        }
        return c;
    }
}
