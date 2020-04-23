package dao;

import entity.Yorum;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class YorumDAO extends Dao {

    private KullaniciDAO kullaniciDAO;
    private AracDAO aracDAO;

    public List read(int page, int pageSize) {
        List<Yorum> clist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConn().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from yorum order by yorumid asc limit " + pageSize + " offset " +start); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                Yorum tmp;
                tmp = new Yorum(rs.getInt("yorumid"), rs.getInt("kullaniciid"), rs.getInt("aracid"), rs.getString("yorum"));

                tmp.setKullanici(this.getKullaniciDAO().find(rs.getInt("kullaniciid")));
                tmp.setArac(this.getAracDAO().find(rs.getInt("aracid")));
                clist.add(tmp);//Her yeni yorumi listeme ekliyorum

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clist;
    }

    public int count() {
        int count = 0;

        try {
            PreparedStatement st = getConn().prepareStatement("select count(yorumid) as yorum_count from yorum");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("yorum_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    @Override
    public void create(Object obj) {
        Yorum yorum = (Yorum) obj;
        String q = "insert into yorum(kullaniciid,aracid,yorum) values (?,?,?)";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setInt(1, yorum.getKullaniciid());
            st.setInt(2, yorum.getAracid());
            st.setString(3, yorum.getYorum());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Object obj) {
        Yorum yorum = (Yorum) obj;
        String q = "delete from yorum where yorumid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setInt(1, yorum.getYorumid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update(Object obj) {
        Yorum yorum = (Yorum) obj;
        String q = "update yorum set kullaniciid=?,aracid=?,yorum=? where yorumid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setInt(1, yorum.getKullaniciid());
            st.setInt(2, yorum.getAracid());
            st.setString(3, yorum.getYorum());
            st.setInt(4, yorum.getYorumid());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public KullaniciDAO getKullaniciDAO() {
        if (kullaniciDAO == null) {
            this.kullaniciDAO = new KullaniciDAO();
        }
        return kullaniciDAO;
    }

    public AracDAO getAracDAO() {
        if (aracDAO == null) {
            this.aracDAO = new AracDAO();
        }
        return aracDAO;
    }

}
