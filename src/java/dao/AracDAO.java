package dao;

import entity.Arac;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AracDAO extends Dao {

    private FirmaDAO firmaDAO;

    public List read(int page, int pageSize) {
        List<Arac> clist = new ArrayList();

        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConn().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from arac order by aracid asc limit " + pageSize + " offset " + start); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                Arac tmp;
                tmp = new Arac(rs.getInt("aracid"), rs.getString("plaka"), rs.getString("marka"), rs.getString("model"), rs.getDouble("motor"), rs.getInt("yil"), rs.getInt("kilometre"), rs.getString("yakit"), rs.getString("vites"), rs.getInt("fiyat"), rs.getInt("firmaid"));

                tmp.setFirma(this.getFirmaDAO().find(rs.getInt("firmaid")));
                clist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return clist;
    }

    public int count() {
        int count = 0;

        try {
            PreparedStatement st = getConn().prepareStatement("select count(aracid) as arac_count from arac");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("arac_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public Arac find(int aracid) {
        Arac a = null;

        try {
            Statement st = this.getConn().createStatement();    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from arac where aracid=" + aracid); //executeQuery veritabanindan veri cekme islemini yapar. 
            rs.next();

            a = new Arac();
            a.setAracid(rs.getInt("aracid"));
            a.setPlaka(rs.getString("plaka"));
            a.setMarka(rs.getString("marka"));
            a.setModel(rs.getString("model"));
            a.setMotor(rs.getDouble("motor"));
            a.setYil(rs.getInt("yil"));
            a.setKilometre(rs.getInt("kilometre"));
            a.setYakit(rs.getString("yakit"));
            a.setYakit(rs.getString("vites"));
            a.setFiyat(rs.getInt("Fiyat"));
            a.setFirmaid(rs.getInt("firmaid"));

        } catch (SQLException ex) {
            System.out.println("ex.getMessage");
        }
        return a;
    }

    @Override
    public void create(Object obj) {
        Arac arac = (Arac) obj;
        String q = "insert into arac(plaka,marka,model,motor,yil,kilometre,yakit,vites,firmaid,fiyat) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
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

    @Override
    public void delete(Object obj) {
        Arac arac = (Arac) obj;
        String q = "delete from arac where aracid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setInt(1, arac.getAracid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update(Object obj) {
        Arac arac = (Arac) obj;
        String q = "update arac set plaka=?,marka=?,model=?,motor=?,yil=?,kilometre=?,yakit=?,vites=?,firmaid=?,fiyat=? where aracid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
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

    public FirmaDAO getFirmaDAO() {
        if (this.firmaDAO == null) {
            this.firmaDAO = new FirmaDAO();
        }
        return firmaDAO;
    }
}
