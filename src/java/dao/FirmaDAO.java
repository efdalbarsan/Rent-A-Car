package dao;

import entity.Firma;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FirmaDAO extends Dao {

    public List read(int page, int pageSize) {
        List<Firma> firmaList = new ArrayList<>();

        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConn().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from firma order by firmaid asc limit " + pageSize + " offset " + start); 

            while (rs.next()) {
                Firma tmp;
                tmp = new Firma(rs.getInt("firmaid"), rs.getString("adi"), rs.getString("telefon"), rs.getString("email"), rs.getString("adres"));
                firmaList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return firmaList;
    }

    public int count() {
        int count = 0;

        try {
            PreparedStatement st = getConn().prepareStatement("select count(firmaid) as firma_count from firma");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("firma_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public Firma find(int firmaid) {
        Firma f = null;

        try {
            Statement st = this.getConn().createStatement();    //sorgulari statement uzerinden yapariz
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

    @Override
    public void create(Object obj) {
        Firma firma = (Firma) obj;
        String q = "insert into firma(adi,telefon,email,adres) values (?,?,?,?)";
        try {
            PreparedStatement st = this.getConn().prepareStatement(q);
            st.setString(1, firma.getAdi());
            st.setString(2, firma.getTelefon());
            st.setString(3, firma.getEmail());
            st.setString(4, firma.getAdres());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Object obj) {
        Firma firma = (Firma) obj;

        String q = "delete from firma where firmaid = ?";
        try {
            PreparedStatement st = this.getConn().prepareStatement(q);
            st.setInt(1, firma.getFirmaid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Object obj) {
        Firma firma = (Firma) obj;
        String q = "update firma set adi=?,telefon=?,email=?,adres=? where firmaid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
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
        public List read() {
        List<Firma> firmaList = new ArrayList<>();

        
        try {
            Statement st = this.getConn().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from firma"); 

            while (rs.next()) {
                Firma tmp;
                tmp = new Firma(rs.getInt("firmaid"), rs.getString("adi"), rs.getString("telefon"), rs.getString("email"), rs.getString("adres"));
                firmaList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return firmaList;
    }
}
