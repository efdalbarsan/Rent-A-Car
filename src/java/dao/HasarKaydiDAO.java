package dao;

import entity.HasarKaydi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HasarKaydiDAO extends Dao {

    private AracDAO aracDAO;

    public List read(int page,int pageSize) {
        List<HasarKaydi> clist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConn().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from hasarkaydi order by hasarid asc limit " + pageSize + " offset " + start);

            while (rs.next()) {
                HasarKaydi tmp;
                tmp = new HasarKaydi(rs.getInt("hasarid"), rs.getInt("aracid"), rs.getString("boya"), rs.getString("cizik"), rs.getString("degisim"), rs.getString("aciklama"));

                tmp.setArac(this.getAracDAO().find(rs.getInt("aracid")));
                clist.add(tmp);//Her yeni hasarKaydii listeme ekliyorum

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clist;
    }

    public int count() {
        int count = 0;

        try {
            PreparedStatement st = getConn().prepareStatement("select count(hasarid) as hasarkaydi_count from hasarkaydi");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("hasarkaydi_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    @Override
    public void create(Object obj) {
        HasarKaydi hasarKaydi = (HasarKaydi) obj;
        String q = "insert into hasarkaydi(aracid,boya,cizik,degisim,aciklama) values (?,?,?,?,?)";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setInt(1, hasarKaydi.getAracid());
            st.setString(2, hasarKaydi.getBoya());
            st.setString(3, hasarKaydi.getCizik());
            st.setString(4, hasarKaydi.getDegisim());
            st.setString(5, hasarKaydi.getAciklama());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Object obj) {
        HasarKaydi hasarKaydi = (HasarKaydi) obj;
        String q = "delete from hasarkaydi where hasarid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setInt(1, hasarKaydi.getHasarid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update(Object obj) {
        HasarKaydi hasarKaydi = (HasarKaydi) obj;
        String q = "update hasarkaydi set aracid=?,boya=?,cizik=?,degisim=?,aciklama=? where hasarid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setInt(1, hasarKaydi.getAracid());
            st.setString(2, hasarKaydi.getBoya());
            st.setString(3, hasarKaydi.getCizik());
            st.setString(4, hasarKaydi.getDegisim());
            st.setString(5, hasarKaydi.getAciklama());
            st.setInt(6, hasarKaydi.getHasarid());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public AracDAO getAracDAO() {
        if (aracDAO == null) {
            aracDAO = new AracDAO();
        }
        return aracDAO;
    }

}
