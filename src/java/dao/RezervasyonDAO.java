package dao;


import entity.Rezervasyon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class RezervasyonDAO {

    private DBConnection connection;
    private Connection c;

    public List<Rezervasyon> getRezervasyon() {
        List<Rezervasyon> clist = new ArrayList();

        try {
            Statement st = this.getC().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from rezervasyon"); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                Rezervasyon tmp;
                tmp = new Rezervasyon(rs.getInt("rezervasyonid"), rs.getInt("aracid"), rs.getInt("musteriid"), rs.getString("aciklama"), rs.getDate("tarih"));
                tmp.setTempDate(String.valueOf(tmp.getTarih()));
                clist.add(tmp);//Her yeni rezervasyoni listeme ekliyorum

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clist;
    }

    public void insert(Rezervasyon rezervasyon) {
        String q = "insert into rezervasyon(aracid,musteriid,aciklama,tarih) values (?,?,?,?)";
        try {
            PreparedStatement st = this.getC().prepareStatement(q);
            st.setInt(1, rezervasyon.getAracid());
            st.setInt(2, rezervasyon.getMusteriid());
            st.setString(3, rezervasyon.getAciklama());
            st.setDate(4, rezervasyon.getTarih());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Rezervasyon rezervasyon) {
        String q = "delete from rezervasyon where rezervasyonid = ?";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setInt(1, rezervasyon.getRezervasyonid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Rezervasyon rezervasyon) {
        String q = "update rezervasyon set aracid=?,musteriid=?,aciklama=?,tarih=? where rezervasyonid = ?";
        System.out.println(rezervasyon.toString());
        try {
            PreparedStatement st = this.getC().prepareStatement(q);
            st.setInt(1, rezervasyon.getAracid());
            st.setInt(2, rezervasyon.getMusteriid());
            st.setString(3, rezervasyon.getAciklama());
            st.setDate(4, rezervasyon.getTarih());
            st.setInt(5, rezervasyon.getRezervasyonid());

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
            this.c = new DBConnection().connect();
        }
        return c;
    }
}
