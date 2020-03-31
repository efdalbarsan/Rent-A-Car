package dao;


import entity.Firma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


import util.DBConnection;

public class FirmaDAO {

    private DBConnection connection;
    private Connection c;

    public Firma find(int firmaid) {
        Firma f = null;

        try {
            Statement st = this.getC().createStatement();    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from firma where firmaid=" + firmaid); //executeQuery veritabanindan veri cekme islemini yapar. 
            rs.next();

            f = new Firma();
            f.setFirmaid(rs.getInt("firmaid"));
            f.setAdi(rs.getString("adi"));
            f.setTelefon(rs.getString("telefon"));
            f.setEmail(rs.getString("email"));
            f.setAdres(rs.getString("Adres"));

        } catch (SQLException ex) {
            System.out.println("ex.getMessage");
        }
        return f;
    }

    public void insert(Firma firma) {
        String q = "insert into firma(adi,telefon,email,adres) values (?,?,?,?)";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setString(1, firma.getAdi());
            st.setString(2, firma.getTelefon());
            st.setString(3, firma.getEmail());
            st.setString(4, firma.getAdres());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Firma firma) {
        String q = "delete from firma where firmaid = ?";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setInt(1, firma.getFirmaid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Firma firma) {
        String q = "update firma set adi=?,telefon=?,email=?,adres=? where firmaid = ?";
        try {
            PreparedStatement st = c.prepareStatement(q);
            st.setString(1, firma.getAdi());
            st.setString(2, firma.getTelefon());
            st.setString(3, firma.getEmail());
            st.setString(4, firma.getAdres());
            st.setInt(5, firma.getFirmaid());
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

    public List<Firma> getFirma() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




}
