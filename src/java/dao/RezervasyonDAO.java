package dao;


import entity.Rezervasyon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RezervasyonDAO extends Dao{

    @Override
    public List read() {
        List<Rezervasyon> clist = new ArrayList();

        try {
            Statement st = this.getConn().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from rezervasyon"); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                Rezervasyon tmp;
                tmp = new Rezervasyon(rs.getInt("rezervasyonid"), rs.getInt("aracid"), rs.getInt("kullaniciid"), rs.getString("aciklama"), rs.getDate("tarih"));
                tmp.setTempDate(String.valueOf(tmp.getTarih()));
                clist.add(tmp);//Her yeni rezervasyoni listeme ekliyorum

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clist;
    }

    @Override
    public void create(Object obj) {
        Rezervasyon rezervasyon = (Rezervasyon) obj;
        String q = "insert into rezervasyon(aracid,kullaniciid,aciklama,tarih) values (?,?,?,?)";
        try {
            PreparedStatement st = this.getConn().prepareStatement(q);
            st.setInt(1, rezervasyon.getAracid());
            st.setInt(2, rezervasyon.getKullaniciid());
            st.setString(3, rezervasyon.getAciklama());
            st.setDate(4, rezervasyon.getTarih());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Object obj) {
        Rezervasyon rezervasyon = (Rezervasyon) obj;
        String q = "delete from rezervasyon where rezervasyonid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setInt(1, rezervasyon.getRezervasyonid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update(Object obj) {
        Rezervasyon rezervasyon = (Rezervasyon) obj;
        String q = "update rezervasyon set aracid=?,kullaniciid=?,aciklama=?,tarih=? where rezervasyonid = ?";
        System.out.println(rezervasyon.toString());
        try {
            PreparedStatement st = this.getConn().prepareStatement(q);
            st.setInt(1, rezervasyon.getAracid());
            st.setInt(2, rezervasyon.getKullaniciid());
            st.setString(3, rezervasyon.getAciklama());
            st.setDate(4, rezervasyon.getTarih());
            st.setInt(5, rezervasyon.getRezervasyonid());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
