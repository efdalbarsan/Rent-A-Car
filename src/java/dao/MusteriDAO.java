package dao;

import entity.Musteri;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class MusteriDAO {

    private DBConnection connection;
    private Connection c;

    public List<Musteri> findAll() {
        List<Musteri> musteriList = new ArrayList<>();

        try {
            Statement st = this.getC().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from musteri"); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                Musteri tmp;
                tmp = new Musteri(rs.getInt("musteriid"), rs.getString("adi"), rs.getString("telefon"), rs.getString("email"), rs.getString("adres"));
                musteriList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println("ex.getMessage");
        }
        return musteriList;
    }
       public void insert(Musteri musteri) {
        String q = "insert into musteri(adi,telefon,email,adres) values (?,?,?,?)";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setString(1, musteri.getAdi());
            st.setString(2, musteri.getTelefon());
            st.setString(3, musteri.getEmail());
            st.setString(4, musteri.getAdres());
           
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
         public void delete(Musteri musteri) {
        String q = "delete from musteri where musteriid = ?";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setInt(1, musteri.getMusteriid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
            public void update(Musteri musteri) {
        String q = "update musteri set adi=?,telefon=?,email=?,adres=? where musteriid = ?";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setString(1, musteri.getAdi());
            st.setString(2, musteri.getTelefon());
            st.setString(3, musteri.getEmail());
            st.setString(4, musteri.getAdres());
            st.setInt(5, musteri.getMusteriid());
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
