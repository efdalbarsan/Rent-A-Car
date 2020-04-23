package dao;

import entity.Grup;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GrupDAO extends Dao {

    public List read(int page, int pageSize) {
        List<Grup> clist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConn().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from grup order by grupid asc limit " + pageSize + " offset " + start); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                Grup tmp;
                tmp = new Grup(rs.getInt("grupid"), rs.getString("grupadi"));

                clist.add(tmp);//Her yeni grupi listeme ekliyorum

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clist;
    }
    
    public int count() {
        int count = 0;

        try {
            PreparedStatement st = getConn().prepareStatement("select count(grupid) as arac_count from grup");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("grup_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public Grup find(int grupid) {
        Grup g = null;

        try {
            Statement st = this.getConn().createStatement();    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from grup where grupid=" + grupid); //executeQuery veritabanindan veri cekme islemini yapar. 
            rs.next();

            g = new Grup();
            g.setGrupid(rs.getInt("grupid"));
            g.setGrupadi(rs.getString("grupadi"));

        } catch (SQLException ex) {
            System.out.println("ex.getMessage");
        }
        return g;
    }

    @Override
    public void create(Object obj) {
        Grup grup = (Grup) obj;
        String q = "insert into grup(grupadi) values (?)";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setString(1, grup.getGrupadi());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Object obj) {
        Grup grup = (Grup) obj;
        String q = "delete from grup where grupid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setInt(1, grup.getGrupid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update(Object obj) {
        Grup grup = (Grup) obj;
        String q = "update grup set grupadi=? where grupid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setString(1, grup.getGrupadi());
            st.setInt(2, grup.getGrupid());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
