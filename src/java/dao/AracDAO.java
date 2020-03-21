package dao;

import entity.Arac;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBConnection;

public class AracDAO {

    private DBConnection connection;
    private Connection c;

    public List<Arac> getArac() {
        List<Arac> clist = new ArrayList();

        try {
            Statement st = this.getC().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from arac"); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                // System.out.println(rs.getString("marka"));
                Arac tmp;
                tmp = new Arac(rs.getInt("aracid"), rs.getString("plaka"), rs.getString("marka"), rs.getString("model"), rs.getDouble("motor"), rs.getInt("yil"), rs.getInt("kilometre"), rs.getString("yakit"), rs.getString("vites"), rs.getInt("fiyat"), rs.getInt("firmaid"));
                clist.add(tmp);//Her yeni araci listeme ekliyorum
            }

        } catch (SQLException ex) {
            System.out.println("ex.getMessage");
        }
        return clist;
    }

    public void insert(Arac arac) {
        String q = "insert into arac(plaka,marka,model,motor,yil,kilometre,yakit,vites,firmaid,fiyat) values (?,?,?,?,?,?,?,?,?,?)";
        System.out.println(arac.toString());
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setString(1, arac.getPlaka());
            st.setString(2, arac.getMarka());
            st.setString(3, arac.getModel());
            st.setDouble(4, arac.getMotor());
            st.setInt(5, arac.getYil());
            st.setInt(6, arac.getKilometre());
            st.setString(7, arac.getYakit());
            st.setString(8, arac.getVites());
            st.setInt(9, arac.getFirmaid());
            st.setInt(10, arac.getFiyat());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Arac arac) {
        String q = "delete from arac where aracid = ?";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setInt(1, arac.getAracid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Arac arac) {
        String q = "update arac set plaka=?,marka=?,model=?,motor=?,yil=?,kilometre=?,yakit=?,vites=?,firmaid=?,fiyat=? where aracid = ?";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setString(1, arac.getPlaka());
            st.setString(2, arac.getMarka());
            st.setString(3, arac.getModel());
            st.setDouble(4, arac.getMotor());
            st.setInt(5, arac.getYil());
            st.setInt(6, arac.getKilometre());
            st.setString(7, arac.getYakit());
            st.setString(8, arac.getVites());
            st.setInt(9, arac.getFirmaid());
            st.setInt(10, arac.getFiyat());
            st.setInt(11, arac.getAracid());
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
